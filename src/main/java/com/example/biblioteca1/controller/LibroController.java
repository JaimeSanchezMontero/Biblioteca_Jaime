package com.example.biblioteca1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca1.model.LibroModel;
import com.example.biblioteca1.service.LibroService;

@RestController
@RequestMapping(value = "/libro")
public class LibroController {

	@Autowired
	LibroService libroService; //Así inyectamos la interfaz
	
	//Ahora creamos el endpoint
	
	 @PostMapping(value = "/save")
	    public LibroModel guardaLibro(@RequestBody LibroModel libro) {
	        System.out.println("Libro recibido: " + libro);
	        LibroModel result = libroService.guardaLibro(libro);

	        if (result == null) {
	            System.out.println("No se pudo guardar el libro.");
	            return null;
	        } else {
	            System.out.println("Libro guardado con éxito: " + result);
	            return result; 
	        }
	    }
	
	
	@GetMapping(value = "/getAll")
	public List <LibroModel> getAllBooks(){
		List<LibroModel> retrieved = null;
		try {
			retrieved = libroService.getAll();
		} catch (Exception ex) {
			System.out.println("exception:: " + ex.getLocalizedMessage());
		}
		return retrieved;
	}
	
	@GetMapping(value = "/get/{id}")
	public LibroModel getByID(@PathVariable(value = "id") Integer id) {
		LibroModel result = new LibroModel();
		
		result = libroService.getLibroByID(id);
		
		return result;
	}
	
	
	@PutMapping(value = "/update/{id}")
    public String actualizarLibro(@PathVariable(value = "id") Integer id, @RequestBody LibroModel libro) {
        boolean isUpdated = libroService.actualizarLibro(id, libro);
        if (isUpdated) {
            return "El libro con ID " + id + " ha sido actualizado correctamente.";
        } else {
            return "Error: El libro con ID " + id + " no existe o no pudo ser actualizado.";
        }
    }
	
	
	 @DeleteMapping(value = "/delete/{id}")
	    public String eliminarLibro(@PathVariable(value = "id") Integer id) {
	        boolean isDeleted = libroService.eliminarLibro(id);
	        if (isDeleted) {
	            return "El libro con ID " + id + " ha sido eliminado correctamente.";
	        } else {
	            return "Error: El libro con ID " + id + " no se encontró o no pudo ser eliminado.";
	        }
	    }
	
	
}
