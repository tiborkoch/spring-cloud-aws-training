package cloud.training.aws.config.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.training.aws.config.service.ICustomerService;
import cloud.training.aws.config.config.ApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;
    private final ApplicationConfiguration configuration;

    @GetMapping
    public ResponseEntity<List<CustomerData>> getCustomers() {
        log.info("Message: {}", configuration.getMessage());
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerData> getCustomerById(@PathVariable("id") Integer id) {
        CustomerData customerData = customerService.findById(id);
        return ResponseEntity.ok(customerData);
    }

    @PostMapping
    public ResponseEntity<CustomerData> createCustomer(@RequestBody CreateCustomerRequest request) {
        CustomerData savedCustomer = customerService.save(request);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerData> updateCustomer(@PathVariable("id") Integer customerId, @RequestBody UpdateCustomerRequest request) {
        CustomerData updatedCustomer = customerService.update(customerId, request);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
