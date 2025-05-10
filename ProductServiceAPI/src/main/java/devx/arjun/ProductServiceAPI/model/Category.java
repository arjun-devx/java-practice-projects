package devx.arjun.ProductServiceAPI.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category extends BaseModel {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id")
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
