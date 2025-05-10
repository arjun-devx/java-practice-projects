package devx.arjun.ProductServiceAPI.exception;

import devx.arjun.ProductServiceAPI.dto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CategoryNotFoundException {

    public CategoryNotFoundException() {
    }
    public CategoryNotFoundException(String message) {
        super();
    }
}
