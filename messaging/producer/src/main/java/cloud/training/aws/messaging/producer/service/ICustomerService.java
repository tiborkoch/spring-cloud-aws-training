package cloud.training.aws.messaging.producer.service;

import java.util.List;

import cloud.training.aws.messaging.producer.controller.UpdateCustomerRequest;
import cloud.training.aws.messaging.producer.controller.CreateCustomerRequest;
import cloud.training.aws.messaging.producer.controller.CustomerData;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
