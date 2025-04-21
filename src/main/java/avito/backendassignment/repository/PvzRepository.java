package avito.backendassignment.repository;

import avito.backendassignment.model.PVZ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface PvzRepository extends CrudRepository<PVZ, Long> {
    Page<PVZ> findAllByRegistrationDateBetween(OffsetDateTime startDate, 
                                             OffsetDateTime endDate, 
                                             Pageable pageable);
}