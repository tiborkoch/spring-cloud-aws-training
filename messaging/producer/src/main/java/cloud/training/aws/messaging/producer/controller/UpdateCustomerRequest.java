package cloud.training.aws.messaging.producer.controller;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String email;

    private String name;
}
