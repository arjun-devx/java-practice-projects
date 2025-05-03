package devx.arjun.ProductServiceAPI.controller;

import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import devx.arjun.ProductServiceAPI.model.Product;
import devx.arjun.ProductServiceAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //below section is for the controller --> services --> repository --> DataBase (products model) - mariaDB

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductByIdRepo (@PathVariable int productId) {
        Product getProductById = productService.getProductRepo(productId);
        return ResponseEntity.ok(getProductById);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProductsRepo () {
        List<Product> getAllProducts = productService.getAllProductRepo();
        return ResponseEntity.ok(getAllProducts);
    }

    @PostMapping ("/product")
    public ResponseEntity<Product> createProductRepo(@RequestBody Product product) {
        Product createProduct = productService.saveProductRepo(product);
        return ResponseEntity.ok(createProduct);
    }

    @PutMapping ("/product/{productId}")
    public ResponseEntity<Product> updateProductRepo (@RequestBody Product newProduct, @PathVariable("productId") int productId) {
        Product updatedProduct = productService.updateProductRepo(newProduct, productId);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping ("/product/{productId}")
    public ResponseEntity<Boolean> deleteProductById (@PathVariable ("productId") int productId) {
        Boolean deleteProduct = productService.deleteProductRepo(productId);
        return ResponseEntity.ok(deleteProduct);
    }



    //This below section is for fakestoreapi and controller --> services --> Client making http call to the fakestoreapi

    @GetMapping ("/product/fake")
    public FakeStoreProductDTO[] getAllProducts() {

        return productService.getAllProductsFromFakeStore();
    }

    @GetMapping ("/product/fake/{Id}")
    public ResponseEntity<FakeStoreProductDTO> getProduct(@PathVariable("Id") int Id) {
        if (Id <= 0) {
            throw new IllegalArgumentException("Product does not exists, provide valid productId");
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        FakeStoreProductDTO fakeStoreProductDTO = productService.getProductFromFakeStore(Id);
        return new ResponseEntity<>(fakeStoreProductDTO, HttpStatus.OK);
    }

    @PostMapping ("/product/fake")
    public FakeStoreProductDTO addProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO) {

        return productService.addProduct(fakeStoreProductDTO);
    }

    @PutMapping ("/product/fake/{Id}")
    public FakeStoreProductDTO updateProduct (@PathVariable("Id") int Id, @RequestBody FakeStoreProductDTO fakeStoreProductDTO) {
        return productService.updateProduct(Id, fakeStoreProductDTO);
    }

    @DeleteMapping ("/product/fake/{productId}")
    public Boolean deleteProduct (@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

    @ExceptionHandler ({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<String> handleException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
