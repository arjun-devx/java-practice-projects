package devx.arjun.ProductServiceAPI.dto;

public class CategoryResponseDTO {
    private String CategoryName;
    private String CategoryDescription;

    public CategoryResponseDTO(String categoryName, String categoryDescription) {
        CategoryName = categoryName;
        CategoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        CategoryDescription = categoryDescription;
    }
}
