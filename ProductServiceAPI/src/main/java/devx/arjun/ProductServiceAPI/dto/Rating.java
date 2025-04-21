package devx.arjun.ProductServiceAPI.dto;

/*
rating object as we found in the fakeStoreAPI response
*/

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Rating {
    private double rate;
    private int count;
}
