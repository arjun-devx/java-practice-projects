package devx.arjun.ProductServiceAPI.controller;

import devx.arjun.ProductServiceAPI.dto.CategoryRequestDTO;
import devx.arjun.ProductServiceAPI.dto.CategoryResponseDTO;
import devx.arjun.ProductServiceAPI.model.Category;
import devx.arjun.ProductServiceAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping ("/v1")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping ("/category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {

        Category category = categoryService.createCategory(categoryRequestDTO);

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(category.getName(), category.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping ("/category/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable ("id") int id) {
        Category savedCategory = categoryService.getCategory(id);
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(savedCategory.getName(), savedCategory.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping ("/category")
    public ResponseEntity<List <CategoryResponseDTO>> getAllCategories () {
        List<Category> allCategories = categoryService.getAllCategory();

        List<CategoryResponseDTO> categoryResponseDTO = new ArrayList<>();

        for (Category category : allCategories) {
            CategoryResponseDTO responseDTO = new CategoryResponseDTO(category.getName(), category.getDescription());
            categoryResponseDTO.add(responseDTO);
        }
        return ResponseEntity.ok(categoryResponseDTO);
    }
}
