package devx.arjun.ProductServiceAPI.repository;

import devx.arjun.ProductServiceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

/*
    Extending JpaRepository which adds all fundamental CRUDD operations methods in ProductRepository Interface
    We don't need to implement these methods, Spring Data JPA will do that for us.
    We will just use them directly.
 */
