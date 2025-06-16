package lk.ijse.userserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/12/2025 2:39 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String username;
   private String email;
   private String password;
   private String role;
}
