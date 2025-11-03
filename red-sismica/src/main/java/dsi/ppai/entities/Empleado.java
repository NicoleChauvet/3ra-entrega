package dsi.ppai.entities;

// imports
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    // Atributos

    private String nombre;
    private String apellido;
    private String mail;
    private int telefono;
    private Rol rol;

}
