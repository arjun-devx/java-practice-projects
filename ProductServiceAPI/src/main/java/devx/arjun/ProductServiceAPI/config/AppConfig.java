package devx.arjun.ProductServiceAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

//configuration -> Spring executes this class during the initial build
// and calls all the methods of this class

//whatever each method returns, it gets injected in the IoC containers as a Bean[object]

// this allows us to use those objects as dependencies at multiple places
