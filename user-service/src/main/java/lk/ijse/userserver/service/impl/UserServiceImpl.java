package lk.ijse.userserver.service.impl;

import lk.ijse.userserver.dto.BookingResponse;
import lk.ijse.userserver.dto.LoginRequest;
import lk.ijse.userserver.dto.RegisterRequest;
import lk.ijse.userserver.dto.UserProfileResponse;
import lk.ijse.userserver.entity.User;
import lk.ijse.userserver.repo.UserRepository;
import lk.ijse.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/15/2025 5:56 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(RegisterRequest request) {
//        User user = new User();
//        user.setEmail(request.getEmail());
//        user.setPassword(request.getPassword()); // encode in real case
//        user.setUsername(request.getUsername());
//        user.setRole("USER");
//        userRepository.save(user);

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already has account");
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            //userDTO.setRole(userDTO.getRole());
            User user = new User();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setRole("USER");
            userRepository.save(user);

        }

    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return "dummy-jwt-token";


    }

    @Override
    public UserProfileResponse getProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserProfileResponse(user.getUsername(), user.getEmail(),user.getPassword(),user.getRole());
    }

    @Override
    public List<BookingResponse> getUserBookings(String email) {
        // Stub: integrate with BookingService
        return List.of(new BookingResponse(1L, "Zone A", "2025-06-07 10:00 AM"));
    }

    @Override
    public UserProfileResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        return new UserProfileResponse(user.getUsername(), user.getEmail(), user.getPassword(),user.getRole());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return  new org.springframework.security.core.userdetails.User( user.getEmail(),user.getPassword(),getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
}
