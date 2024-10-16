package com.example.biblioteca1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca1.model.AutorModel;
import com.example.biblioteca1.repository.AutorRepository;
import com.example.biblioteca1.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
    AutorRepository autorRepo;

    @Override
    public AutorModel guardaAutor(AutorModel autor) {
        AutorModel result = new AutorModel();

        try {
            result = autorRepo.save(autor);
        } catch (Exception e) {
            System.out.println("[guardaAutor] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public AutorModel getAutorByID(Integer id) {
        AutorModel result = null;

        try {
            Optional<AutorModel> autorOptional = autorRepo.findById(id);
            if (autorOptional.isPresent()) {
                result = autorOptional.get();
            } else {
                System.out.println("El autor con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            System.out.println("[getAutorByID] exception: " + e.getMessage());
        }

        return result;
    }
    
    
    @Override
    public List<AutorModel> getAll() {
        return autorRepo.findAll();
    }
    
    
    
    @Override
    public AutorModel actualizarAutor(Integer id, String nuevoNombre) {
        AutorModel result = null;
        try {
            Optional<AutorModel> autorOptional = autorRepo.findById(id);
            if (autorOptional.isPresent()) {
                AutorModel autor = autorOptional.get();
                autor.setNombre_autor(nuevoNombre);  // Cambiar el nombre del autor
                result = autorRepo.save(autor);      // Guardar los cambios
            } else {
                System.out.println("El autor con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            System.out.println("[actualizarAutor] exception: " + e.getMessage());
        }
        return result;
    }
    
    
    @Override
    public boolean eliminarAutor(Integer id) {
        try {
            Optional<AutorModel> autorOptional = autorRepo.findById(id);
            if (autorOptional.isPresent()) {
                autorRepo.deleteById(id); // Eliminamos el autor por su ID
                return true;
            } else {
                System.out.println("El autor con ID " + id + " no existe.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("[eliminarAutor] exception: " + e.getMessage());
            return false;
        }
    }
}
