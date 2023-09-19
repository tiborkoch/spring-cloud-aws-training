package cloud.training.aws.observability.controller;

import cloud.training.aws.observability.domain.ProductType;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;
}
