package avito.backendassignment.service;

import avito.backendassignment.model.User;
import avito.backendassignment.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }
    
    public boolean existsByEmail(String username) {
        return repo.findByEmail(username).isPresent();
    }
}
