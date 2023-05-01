package com.kafka.productor.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "pruebas", name = "ControlMsg")
public class Reporte {
    @Id
    @Column(name = "Id")
    private String Id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Mensaje")
    private String mensaje;

    @Column (name = "Estado")
    private String estado;
}
