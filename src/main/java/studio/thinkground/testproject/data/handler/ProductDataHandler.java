package studio.thinkground.testproject.data.handler;

import studio.thinkground.testproject.data.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity getProductEntity(String productId);
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);
}
