package cloud.training.aws.messaging.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.training.aws.messaging.producer.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
