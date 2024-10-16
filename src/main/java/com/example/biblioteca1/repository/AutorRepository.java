package com.example.biblioteca1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca1.model.AutorModel;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Integer> {

}
