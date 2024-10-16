package com.example.biblioteca1.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Libro")
public class LibroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Codigo_libro;
	
	private String titulo;
	
	private Integer año;
	
	private Integer codigo_idioma;

	
	
	public Integer getIdLibro() {
		return Codigo_libro;
	}

	public void setIdLibro(Integer codigo_libro) {
		this.Codigo_libro = codigo_libro;
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


	public Integer getCodigo_idioma() {
		return codigo_idioma;
	}

	public void setCodigo_idioma(Integer codigo_idioma) {
		this.codigo_idioma = codigo_idioma;
	}
	
	
	
}
