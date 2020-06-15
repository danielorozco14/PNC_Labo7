package com.uca.labo7.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.labo7.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName="labo7")
	public EntityManager entityManager;
	
	@Override
	@Transactional
	public void save (Estudiante estudiante) throws DataAccessException {
		
		try {
			if(estudiante.getCodigoUsuario()==null) {
				entityManager.persist(estudiante);
			}else {
				entityManager.merge(estudiante);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException{
		Estudiante est =entityManager.find(Estudiante.class, codigoEstudiante);
		entityManager.remove(est);
	}

	@Override
	public List<Estudiante> findAllEstudiante() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM PUBLIC.ESTUDIANTE;");//SINO FUNCIONA QUITAR ';' A LA QUERY
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List <Estudiante> result= query.getResultList();
		return result;
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		Estudiante est = entityManager.find(Estudiante.class, code);
		
		return est;
	}
	
	

}
