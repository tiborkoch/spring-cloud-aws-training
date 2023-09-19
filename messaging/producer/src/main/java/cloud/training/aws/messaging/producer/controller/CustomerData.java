package cloud.training.aws.messaging.producer.controller;

import lombok.Data;

@Data
public class CustomerData {

    private Integer id;

    private String email;

    private String name;
}
