package com.practicaTres.version1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arboles")
public class Arboles implements Serializable{//Serealizacion funciona para almacenar ciertos datos en la maquina
    
    private static final long serialVersionUID = 1L;//para poder hacer el ciclo de la sumatoria del idArboles
    @Id //tabla arboles tiene una llave o identificador que va a ser el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Los valores generados que tipo de estrategia utilizan, identico = sea igual en la BD y en la clase
    @Column(name="id_arboles")//decir cual es el nombre de la columna de la base de datos  
    private long idArboles;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Arboles() {
    }

    public Arboles(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
