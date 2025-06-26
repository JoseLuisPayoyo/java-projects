package jose.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data //genera los metodos getter y setters
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con todos los parametros
@ToString //genera el metodo toString
@EqualsAndHashCode

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //en vez de int, para que sea null
    private String nombre;
    private String apellido;
    private Integer membresia;
}
