package lk.ijse.paymentservice.client;

import lk.ijse.paymentservice.dto.ParkingRecordDTO;
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

    private String parkingServiceUrl =  "http://localhost:8083";


    public ParkingRecordDTO getParkingRecordById(Long id) {
        return webClientBuilder.build()
                .put()
                .uri(parkingServiceUrl + "/api/v1/parking-records/end/" + id)
                .retrieve()
                .bodyToMono(ParkingRecordDTO.class)
                .block(); // blocks until response arrives
    }

}

