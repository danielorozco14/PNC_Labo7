package com.uca.labo7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.labo7.dao.EstudianteDAO;
import com.uca.labo7.domain.Estudiante;
import com.uca.labo7.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findAll();
	}

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(codigo);
	}

	@Override
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		//estudianteDao.save(estudiante);
		estudianteRepo.save(estudiante);
		
	}

	@Override
	public void delete(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		//estudianteDao.delete(codigo);
		estudianteRepo.deleteById(codigo);
		
	}
	
	@Override
	public List<Estudiante> filtrarPor(String Nombre) throws DataAccessException{
		return estudianteRepo.findByNombre(Nombre);
	}
	@Override
	public List<Estudiante> startingWith(String Apellido) throws DataAccessException{
		
		return estudianteRepo.findByApellidoStartingWith(Apellido);
	}

}
