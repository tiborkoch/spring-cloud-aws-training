package cloud.training.aws.oauth2.resourceserver.dto;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String email;

    private String name;
}
