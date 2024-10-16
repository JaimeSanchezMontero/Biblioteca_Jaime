package com.example.biblioteca1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca1.model.SocioModel;
import com.example.biblioteca1.repository.SocioRepository;
import com.example.biblioteca1.service.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

	@Autowired
    private SocioRepository socioRepo;

    @Override
    public SocioModel guardaSocio(SocioModel socio) {
        SocioModel result = new SocioModel();
        try {
            result = socioRepo.save(socio);
        } catch (Exception e) {
            System.out.println("[guardaSocio] exception:" + e.getMessage());
        }
        return result;
    }
    
    
    @Override
    public List<SocioModel> getAllSocios() {
        return socioRepo.findAll();
    }
    
    
    @Override
    public SocioModel getSocioById(Integer id) {
        SocioModel result = null;
        try {
            Optional<SocioModel> socioOptional = socioRepo.findById(id);
            if (socioOptional.isPresent()) {
                result = socioOptional.get();
            } else {
                System.out.println("El socio con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            System.out.println("[buscarSocioPorId] exception: " + e.getMessage());
        }
        return result;
    }
    
    
    @Override
    public boolean actualizarSocio(Integer id, SocioModel socio) {
        try {
            Optional<SocioModel> socioExistente = socioRepo.findById(id);
            if (socioExistente.isPresent()) {
                SocioModel socioToUpdate = socioExistente.get();
                // Actualizamos los campos con los valores nuevos
                socioToUpdate.setDni(socio.getDni());
                socioToUpdate.setNombre_socio(socio.getNombre_socio());
                socioToUpdate.setDomicilio(socio.getDomicilio());
                socioToUpdate.setTelefono(socio.getTelefono());

                // Guardamos el socio actualizado
                socioRepo.save(socioToUpdate);
                return true;
            } else {
                System.out.println("El socio con ID " + id + " no existe.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("[actualizarSocio] exception: " + e.getMessage());
            return false;
        }
    }
    
    
    @Override
    public boolean eliminarSocio(Integer id) {
        Optional<SocioModel> socio = socioRepo.findById(id);
        if (socio.isPresent()) {
            socioRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
