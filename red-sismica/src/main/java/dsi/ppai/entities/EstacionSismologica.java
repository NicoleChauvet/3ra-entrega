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
public class EstacionSismologica {

    // Atributos

    private int codigoEstacion;
    private String nombre;
    private String documentoCertificacionAdq;
    private LocalDateTime fechaSolicitudCertificacion;
    private String latitud;
    private String longitud;
    private int nroCertificacionAdquisicion;

}
