package cloud.training.aws.sql.domain;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO - add annotations to prepare this object to be used with DynamoDB
@Setter
@NoArgsConstructor
public class Product {

    private UUID id;

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }
}
