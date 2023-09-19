package cloud.training.aws.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.training.aws.cache.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
