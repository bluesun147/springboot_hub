package studio.thinkground.testproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.data.dto.ProductDto;
import studio.thinkground.testproject.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    // 로거 사용
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 하나 가져오기. ProductDto로 리턴
    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info(
                "[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(),
                productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
                (System.currentTimeMillis() - startTime));

        return productDto;
    }

    // 상품 등록
//    @PostMapping("/product")
//    public ProductDto createProduct(@RequestBody ProductDto productDto) {
//
//        String productId = productDto.getProductId();
//        String productName = productDto.getProductName();
//        int productPrice = productDto.getProductPrice();
//        int productStock = productDto.getProductStock();
//
//        return productService.saveProduct(productId, productName, productPrice, productStock);
//    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) { // @Valid로 validation 실행

        LOGGER.info("[createProduct] perform {} of Around Hub API.", "createProduct");

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        // 근데 productService는 인터페이스 아님? impl은 어디서 쓰이는 거야
        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info(
                "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(),
                response.getProductStock());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 상품 삭제
    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }
}
