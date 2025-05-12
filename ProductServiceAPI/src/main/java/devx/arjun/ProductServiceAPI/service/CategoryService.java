package devx.arjun.ProductServiceAPI.service;

import devx.arjun.ProductServiceAPI.dto.CategoryRequestDTO;
import devx.arjun.ProductServiceAPI.dto.CategoryResponseDTO;
import devx.arjun.ProductServiceAPI.exception.CategoryNotFoundException;
import devx.arjun.ProductServiceAPI.exception.DuplicateCategoryNameException;
import devx.arjun.ProductServiceAPI.model.Category;
import devx.arjun.ProductServiceAPI.model.Product;
import devx.arjun.ProductServiceAPI.repository.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;

    public Category createCategory(CategoryRequestDTO categoryRequestDTO) {

        Optional<Category> categoryOptional = categoryRepository.findByName(categoryRequestDTO.getCategoryName());
        if (categoryOptional.isPresent()) {
            throw new DuplicateCategoryNameException("Duplicate Category name, category already exists" + categoryRequestDTO.getCategoryName());
        }
        //lambda expression - alternate code for above
        /*
        Category savedCategory = categoryRepository.findByName(categoryRequestDTO.getCategoryName()).orElseThrow(
            () -> new DuplicateCategoryNameException("Duplicate Category name " + categoryRequestDTO.getCategoryName())
        );
        */
        Category category = new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        category.setDescription(categoryRequestDTO.getCategoryDescription());
        return categoryRepository.save(category);
    }

    public Category getCategory(int categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow (
                () -> new CategoryNotFoundException("Category not found " + categoryId)
        );
        return savedCategory;
    }

    public List<Category> getAllCategory () {
        return categoryRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(int categoryId) {
        Category savedCategory = getCategory(categoryId);
        List<Product> products = savedCategory.getProducts();
        return products;
    }

    public boolean deleteCategory(int categoryId) {
        Category category = getCategory(categoryId);
        for (Product product : category.getProducts()) {
            productService.deleteProduct(product.getId());
        }
        categoryRepository.deleteById(categoryId);
        return true;
    }
}
