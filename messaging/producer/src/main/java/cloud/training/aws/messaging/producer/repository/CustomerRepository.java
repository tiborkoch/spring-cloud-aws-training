package cloud.training.aws.messaging.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.training.aws.messaging.producer.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
