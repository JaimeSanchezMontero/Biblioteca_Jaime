package com.example.biblioteca1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Autor")
public class AutorModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Codigo_autor;

	@JsonProperty("nombre_autor")
    private String nombre_autor;

    // Getters y Setters

    public Integer getCodigo_autor() {
        return Codigo_autor;
    }

    public void setCodigo_autor(Integer codigo_autor) {
        this.Codigo_autor = codigo_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }
}
