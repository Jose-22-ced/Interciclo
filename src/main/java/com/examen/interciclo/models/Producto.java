package com.examen.interciclo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="productos")
@Entity
@Data

public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 100,nullable = false)
    private String descripcion;


    @Column(scale = 2,nullable = false)
    private double precio;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double total;

}
