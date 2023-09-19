package cloud.training.aws.blob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.training.aws.blob.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
