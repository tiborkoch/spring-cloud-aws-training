package cloud.training.aws.messaging.consumer.service;

import java.util.List;

import cloud.training.aws.messaging.consumer.controller.CreateCustomerRequest;
import cloud.training.aws.messaging.consumer.controller.CustomerData;
import cloud.training.aws.messaging.consumer.controller.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
