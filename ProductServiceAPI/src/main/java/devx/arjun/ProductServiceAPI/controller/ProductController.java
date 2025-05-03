package devx.arjun.ProductServiceAPI.controller;

import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
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

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping ("/product")
    public FakeStoreProductDTO[] getAllProducts() {

        return productService.getAllProductsFromFakeStore();
    }

    @GetMapping ("/product/{Id}")
    public ResponseEntity<FakeStoreProductDTO> getProduct(@PathVariable("Id") int Id) {
        if (Id <= 0) {
            //throw new IllegalArgumentException("Product does not exists, provide valid productId");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        FakeStoreProductDTO fakeStoreProductDTO = productService.getProductFromFakeStore(Id);
        return new ResponseEntity<>(fakeStoreProductDTO, HttpStatus.OK);
    }

    @PostMapping ("/product")
    public FakeStoreProductDTO addProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO) {

        return productService.addProduct(fakeStoreProductDTO);
    }

    @PutMapping ("/product/{Id}")
    public FakeStoreProductDTO updateProduct (@PathVariable("Id") int Id, @RequestBody FakeStoreProductDTO fakeStoreProductDTO) {
        return productService.updateProduct(Id, fakeStoreProductDTO);
    }

    @DeleteMapping ("/product/{productId}")
    public Boolean deleteProduct (@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
