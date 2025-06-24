package lk.ijse.apigateway.client;

import lk.ijse.apigateway.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserClient {
    private final WebClient webClient;

    public UserClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081/user-service").build();
    }

    public Mono<UserDTO> getUserByEmail(String email) {
        return webClient.get()
                .uri("/api/v1/user/profile/{email}", email)
                .retrieve()
                .bodyToMono(UserDTO.class);
    }




}
