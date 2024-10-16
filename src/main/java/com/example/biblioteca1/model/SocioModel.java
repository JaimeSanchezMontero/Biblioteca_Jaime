package com.example.biblioteca1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Socio")
public class SocioModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Codigo_socio;

	@JsonProperty("dni")
    private String dni;
    @JsonProperty("nombre_socio")
    private String nombre_socio;
    @JsonProperty("domicilio")
    private String domicilio;
    @JsonProperty("telefono")
    private String telefono;

    // Getters y Setters

    public Integer getCodigo_socio() {
        return Codigo_socio;
    }

    public void setCodigo_socio(Integer codigo_socio) {
        this.Codigo_socio = codigo_socio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_socio() {
        return nombre_socio;
    }

    public void setNombre_socio(String nombre_socio) {
        this.nombre_socio = nombre_socio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
