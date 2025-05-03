package devx.arjun.ProductServiceAPI.service;
import devx.arjun.ProductServiceAPI.client.FakeStoreClient;
import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import devx.arjun.ProductServiceAPI.exception.ProductNotFoundException;
import devx.arjun.ProductServiceAPI.model.Product;
import devx.arjun.ProductServiceAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Autowired
    private ProductRepository productRepository;

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
    public Product saveProductRepo(Product newProduct) {
        Product savedProduct = productRepository.save(newProduct);
        return savedProduct;
    }
    public Product updateProductRepo (Product newProduct, int productId) {
        Product findProduct = getProductRepo(productId);
        newProduct.setId(productId);
        Product updatedProduct = productRepository.save(newProduct);
        return updatedProduct;
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
