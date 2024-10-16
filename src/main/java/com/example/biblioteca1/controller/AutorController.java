package com.example.biblioteca1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca1.model.AutorModel;
import com.example.biblioteca1.service.AutorService;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

	@Autowired
    AutorService autorService; // Inyección de la interfaz del servicio

    // Endpoint para guardar un nuevo autor
    @PostMapping(value = "/save")
    public AutorModel guardaAutor(@RequestBody AutorModel autor) {
        AutorModel result = autorService.guardaAutor(autor);
        return result;
    }
    
    
    @GetMapping(value = "/getAll")
    public List<AutorModel> getAllAutores() {
        List<AutorModel> retrieved = null;
        try {
            retrieved = autorService.getAll(); // Llamamos al método del servicio
        } catch (Exception ex) {
            System.out.println("exception:: " + ex.getLocalizedMessage());
        }
        return retrieved;
    }
    

    // Endpoint para obtener un autor por su ID
    @GetMapping(value = "/get/{id}")
    public AutorModel getByID(@PathVariable(value = "id") Integer id) {
        AutorModel result = autorService.getAutorByID(id);
        return result;
    }
    
    
    @PutMapping(value = "/update/{id}")
    public AutorModel actualizarAutor(@PathVariable(value = "id") Integer id, @RequestBody AutorModel nuevoAutor) {
        // Aquí solo necesitamos el nuevo nombre del autor
        AutorModel result = autorService.actualizarAutor(id, nuevoAutor.getNombre_autor());
        return result;
    }
    
    
    @DeleteMapping(value = "/delete/{id}")
    public String eliminarAutor(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = autorService.eliminarAutor(id);
        if (isDeleted) {
            return "El autor con ID " + id + " ha sido eliminado correctamente.";
        } else {
            return "Error: El autor con ID " + id + " no existe o no pudo ser eliminado.";
        }
    }
}
