package cloud.training.aws.oauth2.resourceserver.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.training.aws.oauth2.resourceserver.dto.AuthenticatedUserDetails;
import cloud.training.aws.oauth2.resourceserver.dto.CreateCustomerRequest;
import cloud.training.aws.oauth2.resourceserver.dto.CustomerData;
import cloud.training.aws.oauth2.resourceserver.dto.UpdateCustomerRequest;
import cloud.training.aws.oauth2.resourceserver.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @Secured({"role_user", "role_admin"})
    public ResponseEntity<List<CustomerData>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Secured("role_user")
    public ResponseEntity<CustomerData> getCustomerById(@PathVariable("id") Integer id) {
        CustomerData customerData = customerService.findById(id);
        return ResponseEntity.ok(customerData);
    }

    @PostMapping
    @Secured("role_admin")
    public ResponseEntity<CustomerData> createCustomer(@RequestBody CreateCustomerRequest request) {
        CustomerData savedCustomer = customerService.save(request);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{id}")
    @Secured("role_admin")
    public ResponseEntity<CustomerData> updateCustomer(@PathVariable("id") Integer customerId, @RequestBody UpdateCustomerRequest request) {
        CustomerData updatedCustomer = customerService.update(customerId, request);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    @Secured("role_admin")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    @Secured("role_user")
    public ResponseEntity<AuthenticatedUserDetails> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<>(new AuthenticatedUserDetails(user), HttpStatus.OK);
    }
}
