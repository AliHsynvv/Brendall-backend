package az.ecommerce.msproduct.repository;

import az.ecommerce.msproduct.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepo extends JpaRepository<Size, Long> {
}
