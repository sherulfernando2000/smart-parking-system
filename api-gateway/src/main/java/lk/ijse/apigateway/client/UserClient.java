package lk.ijse.apigateway.client;

import lk.ijse.apigateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class UserClient {
//    private final WebClient webClient;

//    public UserClient(WebClient.Builder builder) {
//        this.webClient = builder.baseUrl("http://localhost:8080").build();
//    }
    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<UserDTO> getUserByEmail(String email) {
        try {
            return webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/user-service/api/v1/user/profile/" +email)  //
                    .retrieve()
                    .bodyToMono(UserDTO.class);


        } catch (Exception ex) {
            ex.printStackTrace();
            throw  new RuntimeException();
        }
//        return webClient.get()
//                .uri("/user-service/api/v1/user/profile/{email}", email)
//                .retrieve()
//                .bodyToMono(UserDTO.class);
    }




}
