package com.examen.interciclo.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
public class ProductoResponse implements Serializable {

    private Long codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    private double total;
}
