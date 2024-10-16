package com.example.biblioteca1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Idioma")
public class IdiomaModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Codigo_idioma;

    private String Descripcion;

    // Getters y Setters

    public Integer getCodigo_idioma() {
        return Codigo_idioma;
    }

    public void setCodigo_idioma(Integer codigo_idioma) {
        this.Codigo_idioma = codigo_idioma;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
}
