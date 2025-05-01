package devx.arjun.ProductServiceAPI.client;

import devx.arjun.ProductServiceAPI.dto.FakeStoreProductDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductDTO[] getAllProducts() {
        String getAllProductURL = "https://fakestoreapi.com/products";
        FakeStoreProductDTO[] response = restTemplate.getForObject(getAllProductURL, FakeStoreProductDTO[].class);
        return response;
    }

    public FakeStoreProductDTO getProduct(int productId) {
        String getProduct = "https://fakestoreapi.com/products/" + productId;
        FakeStoreProductDTO response = restTemplate.getForObject(getProduct, FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO addProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        String url = "https://fakestoreapi.com/products/";
        FakeStoreProductDTO response = restTemplate.postForObject(url, fakeStoreProductDTO, FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO updateProduct(int id, FakeStoreProductDTO fakeStoreProductDTO) {
        String url = "https://fakestoreapi.com/products/" + id;
        return putForObject(url, fakeStoreProductDTO, FakeStoreProductDTO.class);
    }


    @Nullable
    private <T> T putForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, (Object[])uriVariables);
    }
}
