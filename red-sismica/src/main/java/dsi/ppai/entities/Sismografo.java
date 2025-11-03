package dsi.ppai.entities;

import java.time.LocalDateTime;
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
public class Sismografo {

    // Atributos

    private String idSismografo;
    private LocalDateTime fechaAdquisicion;
    private int nroSerie;
    private List<CambioEstado> cambiosEstado;
    private EstacionSismologica estacionSismologica;
    private Empleado responsableInspeccion;
    private EstadoSismografo estadoActual;

}
