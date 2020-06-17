package com.uca.labo7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.labo7.domain.Estudiante;
import com.uca.labo7.service.*;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;	
	
	@RequestMapping(value="/")//ESTA DA LA UI DE LOS BOTONES
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();	
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/agregarEstudiante")//ESTA SOLO DA LA UI PARA AGREGAR
	public ModelAndView agregarEstudiante() {
		
		ModelAndView mav = new ModelAndView();
		
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("ingresarEstudiante");
		
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)//ESTA ES LA QUE INSERTA
	public ModelAndView insertOne(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();		
		try {
			if(result.hasErrors()) {
					mav.setViewName("index");
			}else {
				estudianteService.save(estudiante);
				mav.setViewName("index");
			}					
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		return mav;
		
	}
	
	@RequestMapping("/borrarEstudiante")//ESTA FUNCION SOLO DA LA UI PARA BORRAR EL DATO
	public ModelAndView borrar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("borrarEstudiante");
		return mav;
	}
	
	@PostMapping("/delete")//ESTA FUNCION ES LA QUE BORRA
	public ModelAndView borrarEstudiante(@RequestParam(value="codigoUsuario")int id) {
		
		ModelAndView mav = new ModelAndView();		
		try {
				estudianteService.delete(id);
				mav.setViewName("index");
							
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		return mav;
	}
	
	
	@RequestMapping("/buscarEstudiante")//Este da la interfaz para buscar
	public ModelAndView buscarEstudiante() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("buscarEstudiante");
		return mav;
	}
	
	
	@PostMapping("/search")//Este busca al estudiante
	public ModelAndView search(@RequestParam(value="codigoUsuario")int id) {
		ModelAndView mav= new ModelAndView();		
		ArrayList<Estudiante> lista= new ArrayList<>();
		try {
			Estudiante est = estudianteService.findOne(id);
			if(est.getCodigoUsuario()!=0) {
				lista.add(est);
			}
			else {
				mav.setViewName("errorBusqueda");
				return mav;
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",lista);
		mav.setViewName("listado");
		
		return mav;
	}
	
	//Editar Estudiante
	@RequestMapping(value = "/editarEstudiante", method= RequestMethod.POST)
	public ModelAndView editar(@RequestParam(value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = estudianteService.findOne(id);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("ingresarEstudiante");		//MIRAR ESTO
		return mav;
	
	}
	
	//Mostrar Lista de Estudiantes
	
	@RequestMapping("/listado")
	public ModelAndView listadoMain() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Estudiante> estudiantes = null;
		try {
			estudiantes=estudianteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		
		return mav;		
	}

}
