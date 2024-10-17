package com.example.biblioteca1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Idioma")
public class IdiomaModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Codigo_idioma;

    private String Descripcion;
    
    //Relacion @OneToMany con Libro
    @OneToMany(mappedBy = "idioma") //Hace referencia al campo "idioma" en LibroModel
    @JsonIgnore //Evitamos el bucle infinito en el Json
    private List<LibroModel> libros;
    
    
    // Getters y Setters

    public Integer getCodigoIdioma() {
        return Codigo_idioma;
    }

    public void setCodigoIdioma(Integer codigo_idioma) {
        this.Codigo_idioma = codigo_idioma;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
    
    public List<LibroModel> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroModel> libros) {
        this.libros = libros;
    }
    
    @Override
    public String toString() {
        return "IdiomaModel{" +
                "Codigo_idioma=" + Codigo_idioma +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
