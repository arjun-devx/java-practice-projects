package devx.arjun.ProductServiceAPI.controller;

import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import devx.arjun.ProductServiceAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping ("/product")
    public FakeStoreProductDTO[] getAllProducts() {

        return productService.getAllProductsFromFakeStore();
    }

    @GetMapping ("/product/{Id}")
    public FakeStoreProductDTO getProduct(@PathVariable int Id) {

        return productService.getProductFromFakeStore(Id);
    }

    @PostMapping ("/product")
    public FakeStoreProductDTO addProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO) {

        return productService.addProduct(fakeStoreProductDTO);
    }

    @PutMapping ("/product/{id}")
    public FakeStoreProductDTO updateProduct (@PathVariable int id, @RequestBody FakeStoreProductDTO fakeStoreProductDTO) {
        return productService.updateProduct(id, fakeStoreProductDTO);
    }

    @DeleteMapping ("/product/{productId}")
    public Boolean deleteProduct (@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
