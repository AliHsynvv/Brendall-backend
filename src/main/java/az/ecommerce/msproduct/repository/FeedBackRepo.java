package az.ecommerce.msproduct.repository;

import az.ecommerce.msproduct.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack, Long> {
}
