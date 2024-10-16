package com.example.biblioteca1.service;
import java.util.List;

import com.example.biblioteca1.model.SocioModel;

public interface SocioService {
	SocioModel guardaSocio(SocioModel socio);
	
    List<SocioModel> getAllSocios();
    
    SocioModel getSocioById(Integer id);
    
    public boolean actualizarSocio(Integer id, SocioModel socio);
    
    public boolean eliminarSocio(Integer id);

	
}
