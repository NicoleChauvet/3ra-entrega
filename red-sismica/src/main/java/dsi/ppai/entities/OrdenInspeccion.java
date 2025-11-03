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
public class OrdenInspeccion {

    // Atributos

    private LocalDateTime fechaHoraCierre;
    private LocalDateTime fechaFinalizacion;
    private LocalDateTime fechaInicio;
    private int nroOrden;
    private String observacionCierre;
    private Empleado empleado;
    private EstacionSismologica estacion;
    private Estado estado;
}
