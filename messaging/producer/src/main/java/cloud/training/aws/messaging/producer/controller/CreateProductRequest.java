package cloud.training.aws.messaging.producer.controller;

import cloud.training.aws.messaging.producer.domain.ProductType;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;
}
