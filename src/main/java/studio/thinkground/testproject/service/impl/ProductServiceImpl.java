package studio.thinkground.testproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.testproject.data.dto.ProductDto;
import studio.thinkground.testproject.data.entity.ProductEntity;
import studio.thinkground.testproject.data.handler.ProductDataHandler;
import studio.thinkground.testproject.service.ProductService;

@Service // 여기가 본체이기 때문에 여기에 어노테이션
public class ProductServiceImpl implements ProductService { // 인터페이스의 구현체

    // 옵션 사항. 데이터 핸들링 작업 필요하면
    ProductDataHandler productDataHandler;

    // 핸들러 의존성 주입
    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }
    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        // 핸들러로 요청 후 돌아오는 값이 엔티티
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        // 엔티티 값은 다시 dto로 변경. 컨트롤러에서는 dto가 필요하기 때문
        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }
}
