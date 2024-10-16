package com.example.biblioteca1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca1.model.IdiomaModel;
import com.example.biblioteca1.repository.IdiomaRepository;
import com.example.biblioteca1.service.IdiomaService;


@Service
public class IdiomaServiceImpl implements IdiomaService {

	@Autowired
    IdiomaRepository idiomaRepo;

    @Override
    public IdiomaModel guardaIdioma(IdiomaModel idioma) {
        IdiomaModel result = new IdiomaModel();
        
        try {
            result = idiomaRepo.save(idioma);
        } catch (Exception e) {
            System.out.println("[guardaIdioma] exception:" + e.getMessage());
        }
        
        return result;
    }
    
    
    @Override
    public List<IdiomaModel> getAll() {
        return idiomaRepo.findAll();
    }
    

    @Override
    public IdiomaModel getIdiomaByID(Integer id) {
        IdiomaModel result = null;
        
        try {
            Optional<IdiomaModel> idiomaOptional = idiomaRepo.findById(id);
            if (idiomaOptional.isPresent()) {
                result = idiomaOptional.get();
            } else {
                System.out.println("El idioma con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            System.out.println("[getIdiomaByID] exception:" + e.getMessage());
        }
        
        return result;
    }
    
    
    @Override
    public IdiomaModel actualizarIdioma(Integer id, String nuevaDescripcion) {
        IdiomaModel result = null;
        
        try {
            Optional<IdiomaModel> idiomaOptional = idiomaRepo.findById(id);
            if (idiomaOptional.isPresent()) {
                IdiomaModel idiomaExistente = idiomaOptional.get();
                idiomaExistente.setDescripcion(nuevaDescripcion); // Actualizamos la descripción
                result = idiomaRepo.save(idiomaExistente); // Guardamos los cambios
            } else {
                System.out.println("El idioma con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            System.out.println("[actualizarIdioma] exception: " + e.getMessage());
        }
        
        return result;
    }
    
    
    @Override
    public boolean eliminarIdioma(Integer id) {
        try {
            Optional<IdiomaModel> idiomaOptional = idiomaRepo.findById(id);
            if (idiomaOptional.isPresent()) {
                idiomaRepo.deleteById(id); // Eliminamos el idioma por su ID
                return true;
            } else {
                System.out.println("El idioma con ID " + id + " no existe.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("[eliminarIdioma] exception: " + e.getMessage());
            return false;
        }
    }
}
