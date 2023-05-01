package msa.kafka.proyectoproductor.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Persona {

    @Id
    private String Id ;

    private String Nombre;

    private Integer Edad;

    private String Correo;
}
