package avito.backendassignment.service;

import avito.backendassignment.model.User;
import avito.backendassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import avito.backendassignment.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .roles(user.getRole().toString().toUpperCase())
            .build();
    }
    
    public UserDetails loadUserByRole(String role) {
        return org.springframework.security.core.userdetails.User
            .withUsername(role)
            .password("dummy")
            .roles(role.toUpperCase())
            .build();
    }
}