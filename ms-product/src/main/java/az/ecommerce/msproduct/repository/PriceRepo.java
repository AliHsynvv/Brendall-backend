package az.ecommerce.msproduct.repository;

import az.ecommerce.msproduct.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
}
