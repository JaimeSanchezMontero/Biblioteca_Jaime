package com.example.biblioteca1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca1.model.SocioModel;

@Repository
public interface SocioRepository extends JpaRepository<SocioModel, Integer>{

}
