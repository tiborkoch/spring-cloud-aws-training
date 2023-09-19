package cloud.training.aws.messaging.producer.controller;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String email;

    private String name;
}
