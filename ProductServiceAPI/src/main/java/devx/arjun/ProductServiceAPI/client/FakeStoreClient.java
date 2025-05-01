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
        FakeStoreProductDTO response = genericRequestForObject(url, HttpMethod.POST, fakeStoreProductDTO, FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO updateProduct(int id, FakeStoreProductDTO fakeStoreProductDTO) {
        String url = "https://fakestoreapi.com/products/" + id;
        return genericRequestForObject(url, HttpMethod.PUT, fakeStoreProductDTO, FakeStoreProductDTO.class);
    }

    public Boolean deleteProduct(int productId) {
        String url = "https://fakestoreapi.com/products/" + productId;
        try {
            genericRequestForObject(url, HttpMethod.DELETE, null, FakeStoreProductDTO.class);
            return true;
        } catch (Exception ex){
            return false;
        }
    }


    @Nullable
    private <T> T putForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, (Object[])uriVariables);
    }

    @Nullable
    private <T> T genericRequestForObject(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, (Object[])uriVariables);
    }
    //added generic method with the all the http method support by adding the HttpMethod argument.
}
