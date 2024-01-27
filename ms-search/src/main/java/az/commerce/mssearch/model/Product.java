package az.commerce.mssearch.model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@Builder
@Document(indexName = "products")

public class Product {
    @Id
    private String id;
    private String name;
    @Field(type = FieldType.Keyword) // Use a keyword field for "category"
    private String category;
    private BigDecimal price;
    private String gender;
    private String store;
    private Boolean inStock;
}

