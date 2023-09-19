package cloud.training.aws.blob.service;

import java.util.List;

import cloud.training.aws.blob.controller.CreateCustomerRequest;
import cloud.training.aws.blob.controller.CustomerData;
import cloud.training.aws.blob.controller.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerData save(CreateCustomerRequest request);

    CustomerData update(Integer id, UpdateCustomerRequest request);

    List<CustomerData> findAll();

    CustomerData findById(Integer id);

    void delete(Integer id);
}
