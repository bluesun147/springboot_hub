package studio.thinkground.testproject.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "product") // db에 테이블 자동 생성시 이름
public class ProductEntity {

    @Id // pk를 자바에선 @Id
    String productId;

    String productName;

    Integer productPrice;

    Integer productStock;
}
