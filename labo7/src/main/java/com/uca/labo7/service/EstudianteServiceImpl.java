package com.uca.labo7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.labo7.dao.EstudianteDAO;
import com.uca.labo7.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteDAO estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDao.findAllEstudiante();
	}

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDao.findOne(codigo);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDao.save(estudiante);
		
	}

	@Override
	public void delete(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDao.delete(codigo);
		
	}

}
