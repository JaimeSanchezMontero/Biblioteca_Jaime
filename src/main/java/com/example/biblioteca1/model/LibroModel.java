package com.example.biblioteca1.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Libro")
public class LibroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo_libro;
	
	private String titulo;
	
	private Integer año;
	
	//Se establece relación @ManyToOne con Idioma
	@ManyToOne
	@JoinColumn(name = "Codigo_idioma", nullable = false)
	private IdiomaModel idioma;
	
	
	
	public Integer getCodigoLibro() {
		return codigo_libro;
	}

	public void setCodigoLibro(Integer codigo_libro) {
		this.codigo_libro = codigo_libro;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	// Getters y Setters para codigoIdioma
	public IdiomaModel getIdioma() {
		return idioma;
	}

	public void setIdioma(IdiomaModel idioma) {
		this.idioma = idioma;
	}
	
	@Override
	public String toString() {
	    return "LibroModel{" +
	            "codigo_libro=" + codigo_libro +
	            ", titulo='" + titulo + '\'' +
	            ", año=" + año +
	            ", idioma=" + idioma +
	            '}';
	}
	
	
	
}
