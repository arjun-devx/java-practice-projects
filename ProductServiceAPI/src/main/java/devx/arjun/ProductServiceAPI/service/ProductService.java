package devx.arjun.ProductServiceAPI.service;
import devx.arjun.ProductServiceAPI.client.FakeStoreClient;
import devx.arjun.ProductServiceAPI.dto.CategoryRequestDTO;
import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import devx.arjun.ProductServiceAPI.dto.ProductProjection;
import devx.arjun.ProductServiceAPI.dto.ProductRequestDTO;
import devx.arjun.ProductServiceAPI.exception.CategoryNotFoundException;
import devx.arjun.ProductServiceAPI.exception.ProductNotFoundException;
import devx.arjun.ProductServiceAPI.model.Category;
import devx.arjun.ProductServiceAPI.model.Product;
import devx.arjun.ProductServiceAPI.repository.CategoryRepository;
import devx.arjun.ProductServiceAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Product> getAllProductRepo() {
        return productRepository.findAll();
    }

    public Product getProductRepo(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product Not Found with the Id: " + productId + "value you provided");
        } else {
            return productOptional.get();
        }
    }

    public Product saveProductRepo(ProductRequestDTO productRequestDTO) {

        //check if the category exists before adding the product to it or not?
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("Category does not exists")
        );

        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setRating(productRequestDTO.getRating());

        Product savedProduct = productRepository.save(product);

        savedCategory.getProducts().add(savedProduct);
        categoryRepository.save(savedCategory);

        return savedProduct;
    }

    public List<Product> getProductByDescription(String description) {
      /*  List<Product> products = productRepository.findAll();
        List<Product> matchedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().equals(description)) {
                matchedProducts.add(product);
            }
        }
        return matchedProducts;

       */ //Ideally above piece of code is needed to contact the repository and compare description of the lis of the products received from the productRepository
        //However instead of this, we can also implement custom method in ProductRepository where we can directly make the search based on the incoming input.

        List<Product> matchedProducts  = productRepository.findAllByDescriptionIgnoreCase(description);
        return matchedProducts;
    }

    public Product updateProductRepo (Product newProduct, int productId) {
        Product findProduct = getProductRepo(productId);
        newProduct.setId(productId);
        Product updatedProduct = productRepository.save(newProduct);
        return updatedProduct;
    }

    public ProductProjection getProductProjection (String productName) {
        return productRepository.findFirstByName(productName);
    }

    public Boolean deleteProductRepo(int productId) {
        productRepository.deleteById(productId);
        return true;
    }



    public FakeStoreProductDTO[] getAllProductsFromFakeStore() {
        return fakeStoreClient.getAllProducts();
    }

    public FakeStoreProductDTO getProductFromFakeStore(int Id) {
        return fakeStoreClient.getProduct(Id);
    }

    public FakeStoreProductDTO addProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        return fakeStoreClient.addProduct(fakeStoreProductDTO);
    }

    public FakeStoreProductDTO updateProduct(int id, FakeStoreProductDTO fakeStoreProductDTO) {
        return fakeStoreClient.updateProduct(id, fakeStoreProductDTO);
    }

    public Boolean deleteProduct(int productId) {
        return fakeStoreClient.deleteProduct(productId);
    }
}
