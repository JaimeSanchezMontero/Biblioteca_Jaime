package com.example.biblioteca1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca1.model.LibroModel;
import com.example.biblioteca1.repository.LibroRepository;
import com.example.biblioteca1.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroRepository libroRepo;
	@Override
	public LibroModel guardaLibro(LibroModel libro) {
		LibroModel result = new LibroModel();
		
		try {
			result = libroRepo.save(libro);
		} catch (Exception e) {
			System.out.println("[guardaLibro] exception:" + e.getMessage());
		}
		
		return result;
	}
	
	
	 @Override
	    public List<LibroModel> getAll() {
	        return libroRepo.findAll();
	    }
	 
	
	public LibroModel getLibroByID(Integer id) {
	LibroModel result = null;
		
		try {
			Optional<LibroModel> libroOptional = libroRepo.findById(id);
			if (libroOptional.isPresent()) {
				result = libroOptional.get();
			} else {
				System.out.println("El libro con ID " + id + " no existe.");
			}
		} catch (Exception e) {
			System.out.println("[getLibroByID] exception:" + e.getMessage());
		}
		
		return result;
	}
	
	
	@Override
    public boolean actualizarLibro(Integer id, LibroModel libro) {
        try {
            Optional<LibroModel> libroExistente = libroRepo.findById(id);
            if (libroExistente.isPresent()) {
                LibroModel libroToUpdate = libroExistente.get();
                // Actualizamos los campos con los valores nuevos
                libroToUpdate.setTitulo(libro.getTitulo());
                libroToUpdate.setAño(libro.getAño());
                libroToUpdate.setCodigo_idioma(libro.getCodigo_idioma());

                // Guardamos el libro actualizado
                libroRepo.save(libroToUpdate);
                return true;
            } else {
                System.out.println("El libro con ID " + id + " no existe.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("[actualizarLibro] exception: " + e.getMessage());
            return false;
        }
    }
	
	
	@Override
    public boolean eliminarLibro(Integer id) {
        Optional<LibroModel> libro = libroRepo.findById(id);
        if (libro.isPresent()) {
            libroRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
