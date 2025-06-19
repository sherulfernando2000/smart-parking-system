package lk.ijse.parkingservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:45 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@Component
public class UserClient {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean isUserExists(Long userId) {
        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/user-service/api/v1/user/" + userId)  // Eureka service name
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
            return true;
        } catch (WebClientResponseException.NotFound ex) {
            return false;
        }
    }
}

