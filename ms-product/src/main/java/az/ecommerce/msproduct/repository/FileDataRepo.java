package az.ecommerce.msproduct.repository;

import az.ecommerce.msproduct.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDataRepo extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String fileName);
}
