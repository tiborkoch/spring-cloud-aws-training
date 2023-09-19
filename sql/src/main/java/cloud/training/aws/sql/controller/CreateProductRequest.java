package cloud.training.aws.sql.controller;

import cloud.training.aws.sql.domain.ProductType;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;
}
