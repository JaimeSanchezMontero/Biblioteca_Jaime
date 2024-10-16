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

import com.example.biblioteca1.model.SocioModel;
import com.example.biblioteca1.service.SocioService;

@RestController
@RequestMapping(value = "/socio")
public class SocioController {

	@Autowired
	private SocioService socioService;

	@PostMapping(value = "/save")
	public SocioModel guardaSocio(@RequestBody SocioModel socio) {
		return socioService.guardaSocio(socio);
	}

	@GetMapping("/getAll")
	public List<SocioModel> getAllSocios() {
		return socioService.getAllSocios();
	}
	
	
	@GetMapping(value = "/get/{id}")
    public SocioModel getByID(@PathVariable(value = "id") Integer id) {
        SocioModel result = new SocioModel();
        
        result = socioService.getSocioById(id);
        
        return result;
    }
	
	
	 @PutMapping(value = "/update/{id}")
	    public String actualizarSocio(@PathVariable(value = "id") Integer id, @RequestBody SocioModel socio) {
	        boolean isUpdated = socioService.actualizarSocio(id, socio);
	        if (isUpdated) {
	            return "El socio con ID " + id + " ha sido actualizado correctamente.";
	        } else {
	            return "Error: El socio con ID " + id + " no existe o no pudo ser actualizado.";
	        }
	    }
	 
	 
	 @DeleteMapping(value = "/delete/{id}")
	    public String eliminarSocio(@PathVariable(value = "id") Integer id) {
	        boolean isDeleted = socioService.eliminarSocio(id);
	        if (isDeleted) {
	            return "El socio con ID " + id + " ha sido eliminado correctamente.";
	        } else {
	            return "Error: El socio con ID " + id + " no se encontró o no pudo ser eliminado.";
	        }
	    }
}
