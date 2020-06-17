package com.uca.labo7.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.labo7.domain.*;



public interface EstudianteService {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer codigoEstudiante) throws DataAccessException;

	public List<Estudiante> filtrarPor(String Nombre) throws DataAccessException;

	public List<Estudiante> startingWith(String Apellido) throws DataAccessException;
	
}
