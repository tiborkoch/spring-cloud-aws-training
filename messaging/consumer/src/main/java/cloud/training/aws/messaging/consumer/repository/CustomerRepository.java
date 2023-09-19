package cloud.training.aws.messaging.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.training.aws.messaging.consumer.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
