package com.example.biblioteca1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca1.model.IdiomaModel;
import com.example.biblioteca1.model.LibroModel;
import com.example.biblioteca1.repository.IdiomaRepository;
import com.example.biblioteca1.repository.LibroRepository;
import com.example.biblioteca1.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroRepository libroRepo;
	
	@Autowired
	private IdiomaRepository idiomaRepo;
	
	//Guarda un libro con idioma asociado
	@Override
	public LibroModel guardaLibro(LibroModel libro) {
	    if (libro.getIdioma() == null || libro.getIdioma().getCodigoIdioma() == null) {
	        System.out.println("El idioma no está presente en el libro.");
	        return null;
	    }

	    Optional<IdiomaModel> idiomaOptional = idiomaRepo.findById(libro.getIdioma().getCodigoIdioma());
	    if (idiomaOptional.isPresent()) {
	        libro.setIdioma(idiomaOptional.get()); // Aquí se asignaría el idioma encontrado
	        LibroModel savedLibro = libroRepo.save(libro); // Se guarda el libro
	        System.out.println("Libro guardado con éxito: " + savedLibro);
	        return savedLibro;
	    } else {
	        System.out.println("El idioma con ID " + libro.getIdioma().getCodigoIdioma() + " no existe.");
	        return null;
	    }
	}
	
	
	// Implementación de getAll
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
	        // Buscar el libro existente por ID
	        Optional<LibroModel> libroExistente = libroRepo.findById(id);
	        // Obtener el ID del idioma desde el objeto libro
	        Integer codigoIdioma = libro.getIdioma().getCodigoIdioma();
	        // Verificar si el idioma existe
	        Optional<IdiomaModel> idiomaOptional = idiomaRepo.findById(codigoIdioma);

	        if (libroExistente.isPresent() && idiomaOptional.isPresent()) {
	            // Obtener el libro a actualizar
	            LibroModel libroToUpdate = libroExistente.get();
	            // Actualizar los campos del libro
	            libroToUpdate.setTitulo(libro.getTitulo());
	            libroToUpdate.setAño(libro.getAño());
	            libroToUpdate.setIdioma(idiomaOptional.get()); // Actualizamos el idioma asociado

	            // Guardar el libro actualizado
	            libroRepo.save(libroToUpdate);
	            return true;
	        } else {
	            // Manejo de errores para libro o idioma no encontrado
	            if (!libroExistente.isPresent()) {
	                System.out.println("El libro con ID " + id + " no existe.");
	            }
	            if (!idiomaOptional.isPresent()) {
	                System.out.println("El idioma con ID " + codigoIdioma + " no existe.");
	            }
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
