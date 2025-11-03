package dsi.ppai.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// imports
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CambioEstado {

    // Atributos

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private EstadoSismografo estado;
    private List<MotivoFueraServicio> motivosFueraServicio = new ArrayList<>();

}
