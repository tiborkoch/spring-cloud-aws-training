package cloud.training.aws.cache.service;

import java.util.List;

import cloud.training.aws.cache.controller.CreateCustomerRequest;
import cloud.training.aws.cache.controller.CustomerData;
import cloud.training.aws.cache.controller.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
