package devx.arjun.ProductServiceAPI.repository;

import devx.arjun.ProductServiceAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional <Category> findByName(String name);
}
