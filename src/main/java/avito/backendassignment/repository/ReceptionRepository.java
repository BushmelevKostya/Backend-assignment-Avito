package avito.backendassignment.repository;

import avito.backendassignment.model.Reception;
import avito.backendassignment.model.StatusEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReceptionRepository extends CrudRepository<Reception, UUID> {
    Optional<Reception> findByPvzIdAndStatus(@NotNull Long pvzId, @NotNull StatusEnum status);

    Optional<Reception> findFirstByPvzIdAndStatusOrderByDateTimeDesc(@NotNull Long pvzId, @NotNull StatusEnum status);
}
