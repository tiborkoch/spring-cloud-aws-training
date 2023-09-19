package cloud.training.aws.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.training.aws.config.domain.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
