package com.uca.labo7.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.labo7.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer>{
	
	public List<Estudiante> findByNombre(String Nombre) throws DataAccessException;
	
	public List<Estudiante> findByApellidoStartingWith(String Apellido) throws DataAccessException;
	
	@Query(nativeQuery = true, value = "SELECT * FROM public.estudiante")
	public List<Estudiante> showAll() throws DataAccessException;
	
	@Query(nativeQuery = true, value = "SELECT * FROM public.estudiante WHERE nombre = :Nombre")
	public List<Estudiante> showByName(String Nombre) throws DataAccessException;	
	
}
