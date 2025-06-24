package lk.ijse.apigateway.controller;

import lk.ijse.apigateway.client.UserClient;
import lk.ijse.apigateway.dto.AuthDTO;
import lk.ijse.apigateway.dto.JwtRespone;
import lk.ijse.apigateway.dto.LoginRequest;
import lk.ijse.apigateway.dto.UserDTO;
import lk.ijse.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserClient userClient;

    @PostMapping("/authenticate")
    public Mono<ResponseEntity<?>> authenticate(@RequestBody LoginRequest login) {
        System.out.println("Received login request for email: " + login.getEmail());
        return userClient.getUserByEmail(login.getEmail())
                .flatMap(user -> {
                    System.out.println("User found: " + user.getUsername());
                    if (passwordMatches(login.getPassword(), user.getPassword())) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setUsername(user.getUsername());
                        userDTO.setAuthorities(user.getAuthorities());
                        String token = jwtUtil.generateToken(userDTO);
                        return Mono.just(ResponseEntity.ok(new JwtRespone(token)));
                    }
                    return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
                })
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }

    private boolean passwordMatches(String rawPassword, String hashedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, hashedPassword);
    }
}
