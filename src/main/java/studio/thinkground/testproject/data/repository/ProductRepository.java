package studio.thinkground.testproject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studio.thinkground.testproject.data.entity.ProductEntity;

// JpaRepository 상속. <리포지토리가 사용할 엔티티, 엔티티 pk값의 데이터 타입>
// @Repository // JpaRepository 시용하면 이 어노테이션 안써도 됨.
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
