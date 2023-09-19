package cloud.training.aws.messaging.consumer.controller;

import lombok.Data;

@Data
public class CustomerData {

    private Integer id;

    private String email;

    private String name;
}
