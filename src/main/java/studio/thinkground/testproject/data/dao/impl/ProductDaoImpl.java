package studio.thinkground.testproject.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.testproject.data.dao.ProductDao;
import studio.thinkground.testproject.data.entity.ProductEntity;
import studio.thinkground.testproject.data.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao { // dao 인터페이스 implements

    ProductRepository productRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity); // jpaRepository 제공하는 기본 메서드 (save, getById..)
//        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
