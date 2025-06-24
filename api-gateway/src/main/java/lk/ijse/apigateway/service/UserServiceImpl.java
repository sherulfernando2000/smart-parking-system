package lk.ijse.apigateway.service;

import lk.ijse.apigateway.client.UserClient;
import lk.ijse.apigateway.dto.User;
import lk.ijse.apigateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/22/2025 7:58 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@Service
public class UserServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    private UserClient userClient;



    private UserDetails convertToUserDetails(UserDTO userDTO) {
        return new org.springframework.security.core.userdetails.User(
                userDTO.getEmail(),
                userDTO.getPassword(),
                getAuthorities(userDTO.getRole())
        );
    }

    private Collection<GrantedAuthority> getAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userClient.getUserByEmail(username)
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found with email: " + username)))
                .map(this::convertToUserDetails);
    }

//    @Override
//    public Mono<UserDetails> loadUserByUsername(String email) {
//        // Return a Mono containing UserDetails
//        return userClient.getUserByEmail(email)  // Assuming this returns Mono<UserDTO>
//                .map(userDTO ->
//                        new org.springframework.security.core.userdetails.User(
//                                userDTO.getEmail(),
//                                userDTO.getPassword(),
//                                getAuthorities(userDTO.getRole())
//                        );
//    }
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        UserDTO user = userClient.getUserByEmail(username);
////        User user1 = new User(user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
////        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user1));
////    }
//
//    private Set<SimpleGrantedAuthority> getAuthority(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole()));
//        return authorities;
//    }

}
