package dsi.ppai.entities.EstadosSismografo;

import dsi.ppai.entities.EstadoSismografo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("EnEsperaCertificacion")
public class EnEsperaCertificacion extends EstadoSismografo {
    private String nombre;

}
