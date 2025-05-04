package devx.arjun.ProductServiceAPI.repository;

import devx.arjun.ProductServiceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByDescription(String description);
    List<Product> findAllByDescriptionIgnoreCase(String description);

}

/*
    Extending JpaRepository which adds all fundamental CRUDD operations methods in ProductRepository Interface
    We don't need to implement these methods, Spring Data JPA will do that for us.
    We will just use them directly.
 */