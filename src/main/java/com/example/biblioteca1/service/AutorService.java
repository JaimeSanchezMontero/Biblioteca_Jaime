package com.example.biblioteca1.service;

import java.util.List;

import com.example.biblioteca1.model.AutorModel;

public interface AutorService {

	 AutorModel guardaAutor(AutorModel autor);
	 
	 public List<AutorModel> getAll();

	 AutorModel getAutorByID(Integer id);
	 
	 AutorModel actualizarAutor(Integer id, String nuevoNombre);
 
	 public boolean eliminarAutor(Integer id);
}
