package devx.arjun.ProductServiceAPI.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category extends BaseModel {
    /*
    private String name;
    private String description;{
    "name" : "Galaxy s41",
    "price"  : "29000",
    "description" : "Samsung Phone",
    "rating" : "4.5",
    "quantity": "500"
}

    @OneToMany
    @JoinColumn (name = "category_id")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

     */
}
