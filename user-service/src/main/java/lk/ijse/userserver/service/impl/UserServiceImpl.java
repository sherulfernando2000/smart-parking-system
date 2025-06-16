package lk.ijse.userserver.service.impl;

import lk.ijse.userserver.dto.BookingResponse;
import lk.ijse.userserver.dto.LoginRequest;
import lk.ijse.userserver.dto.RegisterRequest;
import lk.ijse.userserver.dto.UserProfileResponse;
import lk.ijse.userserver.entity.User;
import lk.ijse.userserver.repo.UserRepository;
import lk.ijse.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/15/2025 5:56 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // encode in real case
        user.setUsername(request.getUsername());
        user.setRole("USER");
        userRepository.save(user);
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
        return new UserProfileResponse(user.getUsername(), user.getEmail());
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

        return new UserProfileResponse(user.getUsername(), user.getEmail());
    }
}
