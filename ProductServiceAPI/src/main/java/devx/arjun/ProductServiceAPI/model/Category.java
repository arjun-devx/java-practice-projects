package devx.arjun.ProductServiceAPI.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category extends BaseModel {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn (name = "category_id")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
