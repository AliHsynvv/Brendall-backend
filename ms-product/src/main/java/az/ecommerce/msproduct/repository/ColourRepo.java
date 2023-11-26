package az.ecommerce.msproduct.repository;

import az.ecommerce.msproduct.entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ColourRepo extends JpaRepository<Colour, Long> {
}
