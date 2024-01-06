package az.commerce.msfavproducts.repository;

import az.commerce.msfavproducts.entity.FavProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavProductRepo extends JpaRepository<FavProduct,Long> {

}
