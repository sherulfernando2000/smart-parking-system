package lk.ijse.userserver.service;

import lk.ijse.userserver.dto.BookingResponse;
import lk.ijse.userserver.dto.LoginRequest;
import lk.ijse.userserver.dto.RegisterRequest;
import lk.ijse.userserver.dto.UserProfileResponse;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/15/2025 5:54 AM
 * Project: parking-system
 * ------------------------------------------------
 */
public interface UserService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
    UserProfileResponse getProfile(String email);
    List<BookingResponse> getUserBookings(String email);
    UserProfileResponse getUserById(Long id);

}
