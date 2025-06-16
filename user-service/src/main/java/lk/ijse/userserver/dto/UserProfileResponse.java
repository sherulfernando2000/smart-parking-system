package lk.ijse.userserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/15/2025 5:49 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileResponse {
    private String username;
    private String email;
}
