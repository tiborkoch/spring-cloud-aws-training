package cloud.training.aws.messaging.consumer.controller;

import cloud.training.aws.messaging.consumer.domain.ProductType;
import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;

    private String description;

    private String vendor;

    private double price;

    private ProductType type;
}
