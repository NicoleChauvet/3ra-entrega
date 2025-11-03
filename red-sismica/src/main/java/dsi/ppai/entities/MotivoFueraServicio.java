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
public class MotivoFueraServicio {

    // Atributos

    private String comentario;
    private MotivoTipo tipo;

}
