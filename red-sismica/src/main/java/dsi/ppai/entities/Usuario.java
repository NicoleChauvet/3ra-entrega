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
public class Usuario {

    // Atributos

    private String contraseña;
    private String nombreUsuario;
    private Empleado empleado;

    // Métodos

    public Empleado getRILogueado() {
        return this.empleado;
    }

}
