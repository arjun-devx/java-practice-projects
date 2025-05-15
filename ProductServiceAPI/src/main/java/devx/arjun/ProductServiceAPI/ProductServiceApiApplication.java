package devx.arjun.ProductServiceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ProductServiceApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApiApplication.class, args);
	}
}
