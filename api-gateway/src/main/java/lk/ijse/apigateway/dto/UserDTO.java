package lk.ijse.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private List<Authority> authorities; // Add this

    // Optional: Derived role from authorities[0].authority if needed
    public String getRole() {
        return (authorities != null && !authorities.isEmpty()) ? authorities.get(0).getAuthority() : null;
    }

    // Inner static class to match "authorities"
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Authority {
        private String authority;
    }
}
