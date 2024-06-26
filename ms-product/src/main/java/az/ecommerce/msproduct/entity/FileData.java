package az.ecommerce.msproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@Entity
@Table(name = "FILE_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileDataId;
    private String name;
    private String type;
    private String filePath;

    @ManyToOne
    @JsonBackReference
    private Product product;

    @OneToOne()
    private Store store;

}
