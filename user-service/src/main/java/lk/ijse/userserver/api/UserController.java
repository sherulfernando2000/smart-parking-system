package lk.ijse.userserver.api;

import lk.ijse.userserver.dto.BookingResponse;
import lk.ijse.userserver.dto.LoginRequest;
import lk.ijse.userserver.dto.RegisterRequest;
import lk.ijse.userserver.dto.UserProfileResponse;
import lk.ijse.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/12/2025 7:17 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@RestController
@RequestMapping("user-service/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("get")
    public String getUser(){
        return "User";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getProfile(@RequestParam String email) {
        return ResponseEntity.ok(userService.getProfile(email));
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResponse>> getBookings(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserBookings(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileResponse> getUserById(@PathVariable Long id) {
        UserProfileResponse user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
