package studio.thinkground.testproject.data.dao;

import studio.thinkground.testproject.data.entity.ProductEntity;

public interface ProductDao {
    // 인터페이스이기 때문에 메소드 선언만. 이것을 실체화하는 클래스 만들어서 사용.
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}