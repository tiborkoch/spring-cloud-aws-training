package cloud.training.aws.config.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.training.aws.config.controller.CreateCustomerRequest;
import cloud.training.aws.config.controller.CustomerData;
import cloud.training.aws.config.controller.UpdateCustomerRequest;
import cloud.training.aws.config.repository.CustomerRepository;
import cloud.training.aws.config.domain.Customer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerData save(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setName(request.getName());

        Customer savedCustomer = customerRepository.save(customer);
        return mapEntityToDto(savedCustomer);
    }

    @Override
    public CustomerData update(Integer id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        customer.setEmail(request.getEmail());
        customer.setName(request.getName());

        return mapEntityToDto(customer);
    }

    @Override
    public List<CustomerData> findAll() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerData> result = new ArrayList<>();
        for (Customer customer : customers) {
            result.add(mapEntityToDto(customer));
        }

        return result;
    }

    @Override
    public CustomerData findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapEntityToDto(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    private CustomerData mapEntityToDto(Customer customer) {
        CustomerData data = new CustomerData();
        data.setId(customer.getId());
        data.setEmail(customer.getEmail());
        data.setName(customer.getName());
        return data;
    }
}
