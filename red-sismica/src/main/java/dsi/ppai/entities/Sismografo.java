package dsi.ppai.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sismografo")
public class Sismografo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idSismografo;
    private LocalDateTime fechaAdquisicion;
    private int nroSerie;

    @OneToMany
    private List<CambioEstado> cambiosEstado;

    @ManyToOne
    private EstacionSismologica estacionSismologica;

    @ManyToOne
    private Empleado responsableInspeccion;

    @ManyToOne
    private EstadoSismografo estadoActual;

}
