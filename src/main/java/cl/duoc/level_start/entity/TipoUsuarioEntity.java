package cl.duoc.level_start.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "tipo_usuario")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class TipoUsuarioEntity {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "tu_id")
    private Long id;

    @Column(nullable = false, length = 150, name = "tu_nombre")
    private String nombre;

    @Column(nullable = false, length = 1, name = "tu_activo")
    private Integer activo;
    
}
