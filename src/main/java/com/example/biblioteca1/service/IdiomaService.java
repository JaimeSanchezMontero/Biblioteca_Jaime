package com.example.biblioteca1.service;

import java.util.List;

import com.example.biblioteca1.model.IdiomaModel;

public interface IdiomaService {

	    public IdiomaModel guardaIdioma(IdiomaModel idioma);
	    
	    public List<IdiomaModel> getAll();
	    
	    public IdiomaModel getIdiomaByID(Integer id);
	    
	    public IdiomaModel actualizarIdioma(Integer id, String nuevaDescripcion);

	    public boolean eliminarIdioma(Integer id);

}
