package cloud.training.aws.blob.controller;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String email;

    private String name;
}
