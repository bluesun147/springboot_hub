package studio.thinkground.testproject.data.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studio.thinkground.testproject.data.dao.ProductDao;
import studio.thinkground.testproject.data.entity.ProductEntity;
import studio.thinkground.testproject.data.handler.ProductDataHandler;

@Service
@Transactional // 실제 데이터 변경
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDao productDao;

    @Autowired
    public ProductDataHandlerImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDao.getProduct(productId);
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {

        // 값 받은 것은 엔티티로 생성 후 dao 쪽으로 저장
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDao.saveProduct(productEntity);
    }
}
