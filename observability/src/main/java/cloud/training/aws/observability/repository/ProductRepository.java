package cloud.training.aws.observability.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.training.aws.observability.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
