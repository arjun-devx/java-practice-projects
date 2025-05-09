package devx.arjun.ProductServiceAPI.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass // tells spring that we dont need a table for this class, but we need these columns to be inherited in child class.
public class BaseModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

}
