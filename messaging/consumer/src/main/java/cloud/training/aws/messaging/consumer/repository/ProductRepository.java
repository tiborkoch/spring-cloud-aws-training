package cloud.training.aws.messaging.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.training.aws.messaging.consumer.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
