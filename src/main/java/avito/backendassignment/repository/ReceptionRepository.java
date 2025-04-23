package avito.backendassignment.repository;

import avito.backendassignment.model.Reception;
import avito.backendassignment.model.StatusEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReceptionRepository extends CrudRepository<Reception, UUID> {
    Optional<Reception> findByPvzIdAndStatus(@NotNull Long pvzId, @NotNull StatusEnum status);

    Optional<Reception> findFirstByPvzIdAndStatusOrderByDateTimeDesc(@NotNull Long pvzId, @NotNull StatusEnum status);
    
    @Query("SELECT * FROM receptions WHERE pvz_id = :pvzId AND status = 'IN_PROGRESS' ORDER BY date_time DESC LIMIT 1")
    Optional<Reception> findActiveByPvzId(Long pvzId);
}
