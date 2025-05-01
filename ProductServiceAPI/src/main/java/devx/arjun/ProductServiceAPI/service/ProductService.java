package devx.arjun.ProductServiceAPI.service;
import devx.arjun.ProductServiceAPI.client.FakeStoreClient;
import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

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
}
