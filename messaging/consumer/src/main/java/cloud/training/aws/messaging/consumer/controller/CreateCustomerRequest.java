package cloud.training.aws.messaging.consumer.controller;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String email;

    private String name;
}
