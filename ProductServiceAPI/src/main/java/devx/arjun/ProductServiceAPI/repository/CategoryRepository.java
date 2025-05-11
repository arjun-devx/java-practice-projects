package devx.arjun.ProductServiceAPI.repository;

import devx.arjun.ProductServiceAPI.model.Category;
import devx.arjun.ProductServiceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional <Category> findByName(String name);
    Optional <Category> findByProductsIn(List<Product> products);
}
