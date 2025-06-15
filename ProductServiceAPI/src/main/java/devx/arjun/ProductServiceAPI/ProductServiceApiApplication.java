package devx.arjun.ProductServiceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@RedisHash("admin")
public class ProductServiceApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApiApplication.class, args);
	}
}
