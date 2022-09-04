package studio.thinkground.testproject.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto { // 계층간 어떤 데이터 주고 받을 것인지

    private String productId;
    private String productName;
    private int productPrice;
    private int productStock;
}
