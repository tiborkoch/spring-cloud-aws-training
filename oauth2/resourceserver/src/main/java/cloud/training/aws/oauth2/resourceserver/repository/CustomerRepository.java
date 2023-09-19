package cloud.training.aws.oauth2.resourceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.training.aws.oauth2.resourceserver.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String emailAddress);
}
