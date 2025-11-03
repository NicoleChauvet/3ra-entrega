package dsi.ppai.entities;

import java.time.LocalDateTime;

// imports
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orden_inspeccion")
public class OrdenInspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHoraCierre;
    private LocalDateTime fechaFinalizacion;
    private LocalDateTime fechaInicio;
    private int nroOrden;
    private String observacionCierre;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private EstacionSismologica estacion;

    @Transient
    private Estado estado;
}
