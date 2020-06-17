package com.uca.labo7.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.labo7.domain.Estudiante;

public interface EstudianteDAO {

	public List<Estudiante>findAllEstudiante() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	//@Transactional
	public void save (Estudiante estudiante) throws DataAccessException;
	public void delete (Integer codigoEstudiante) throws DataAccessException;
	
}
