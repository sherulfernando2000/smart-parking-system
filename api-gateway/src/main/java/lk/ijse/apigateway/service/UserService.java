package lk.ijse.apigateway.service;

import lk.ijse.apigateway.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import reactor.core.publisher.Mono;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/22/2025 8:01 AM
 * Project: parking-system
 * ------------------------------------------------
 */
public interface UserService {
    public Mono<UserDetails> loadUserByUsername(String username);
}