package studio.thinkground.testproject.service;

import studio.thinkground.testproject.data.dto.ProductDto;

/*
loose coupling (느슨한 결합도)
서비스에서 인터페이스와 구현 클래스 나눈 구조.
각 객체간 의존성 줄여줌.
ProductService, ProductServiceImpl
바로 클래스에서 구현해 작성하면 db 바군다거나 등등 할때마다 바꿔야 함.
인터페이스로 가져다 쓰자
 */
public interface ProductService {

    ProductDto getProduct(String productId);

    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
}
