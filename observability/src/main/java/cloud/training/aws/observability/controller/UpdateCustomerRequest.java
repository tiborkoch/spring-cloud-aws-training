package cloud.training.aws.observability.controller;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String email;

    private String name;
}
