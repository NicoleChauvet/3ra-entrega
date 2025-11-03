package dsi.ppai.entities;

import java.time.LocalDateTime;

// imports
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sesion {

    // Atributos

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Usuario usuarioLogueado;

    // Métodos

    public Empleado obtenerRILogueado() {
        return this.usuarioLogueado.getRILogueado();
    }

}
