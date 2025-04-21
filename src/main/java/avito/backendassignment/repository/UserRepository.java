package avito.backendassignment.repository;

import avito.backendassignment.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
	Optional<User> findByEmail(String email);
}
