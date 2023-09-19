package cloud.training.aws.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.training.aws.sql.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
