package studio.thinkground.testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.data.dto.ProductDto;
import studio.thinkground.testproject.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 하나 가져오기. ProductDto로 리턴
    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    // 상품 등록
    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    // 상품 삭제
    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }
}
