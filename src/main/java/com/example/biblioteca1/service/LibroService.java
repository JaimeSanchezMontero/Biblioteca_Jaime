package com.example.biblioteca1.service;

import java.util.List;

import com.example.biblioteca1.model.LibroModel;

public interface LibroService {
	
	public List<LibroModel> getAll();

	public LibroModel guardaLibro(LibroModel libro);
	
	public LibroModel getLibroByID(Integer id);
	
    public boolean actualizarLibro(Integer id, LibroModel libro);
    
    public boolean eliminarLibro(Integer id);


}
