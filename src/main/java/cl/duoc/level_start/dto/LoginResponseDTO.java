package cl.duoc.level_start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class LoginResponseDTO {
    private String token;
    private String tipo;
}

