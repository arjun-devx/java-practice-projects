package devx.arjun.ProductServiceAPI.controller;

import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import devx.arjun.ProductServiceAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
