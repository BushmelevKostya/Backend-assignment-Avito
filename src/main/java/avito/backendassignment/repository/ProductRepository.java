package avito.backendassignment.repository;

import avito.backendassignment.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT * FROM products WHERE reception_id = :receptionId ORDER BY date_time DESC")
    List<Product> findByReceptionIdOrderByDateTimeDesc(Long receptionId);
}
