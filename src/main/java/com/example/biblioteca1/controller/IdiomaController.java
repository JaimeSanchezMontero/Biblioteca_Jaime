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

import com.example.biblioteca1.model.IdiomaModel;
import com.example.biblioteca1.service.IdiomaService;

@RestController
@RequestMapping(value = "/idioma")
public class IdiomaController {

	@Autowired
    IdiomaService idiomaService; // Inyección de la interfaz de servicio

    // Endpoint para guardar un idioma
    @PostMapping(value = "/save")
    public IdiomaModel guardaIdioma(@RequestBody IdiomaModel idioma) {
        IdiomaModel result = idiomaService.guardaIdioma(idioma);
        return result;
    }
    
    
    @GetMapping(value = "/getAll")
    public List<IdiomaModel> getAllIdiomas() {
        List<IdiomaModel> retrieved = null;
        try {
            retrieved = idiomaService.getAll(); // Llamamos al método del servicio
        } catch (Exception ex) {
            System.out.println("exception:: " + ex.getLocalizedMessage());
        }
        return retrieved;
    }

    // Endpoint para obtener un idioma por su ID
    @GetMapping(value = "/get/{id}")
    public IdiomaModel getByID(@PathVariable(value = "id") Integer id) {
        IdiomaModel result = idiomaService.getIdiomaByID(id);
        return result;
    }
    
    @PutMapping(value = "/update/{id}")
    public IdiomaModel actualizarIdioma(@PathVariable(value = "id") Integer id, @RequestBody IdiomaModel nuevoIdioma) {
        IdiomaModel result = idiomaService.actualizarIdioma(id, nuevoIdioma.getDescripcion());
        return result;
    }
    
    
    @DeleteMapping(value = "/delete/{id}")
    public String eliminarIdioma(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = idiomaService.eliminarIdioma(id);
        if (isDeleted) {
            return "El idioma con ID " + id + " ha sido eliminado correctamente.";
        } else {
            return "Error: El idioma con ID " + id + " no existe o no pudo ser eliminado.";
        }
    }
}
