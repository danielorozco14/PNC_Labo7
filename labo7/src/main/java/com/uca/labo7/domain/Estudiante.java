package com.uca.labo7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_usuario")	
	private Integer codigoUsuario;
	
	@Size(message="El nombre no debe ser mas grande que 30 caracteres",max=50)
	@NotEmpty(message="Campo Obligatorio")
	@Column(name="nombre")
	private String Nombre;
	
	@Size(message="El apellido no debe ser mas grande que 30 caracteres",max=50)
	@NotEmpty(message="Campo Obligatorio")	
	@Column(name="apellido")
	private String Apellido;
	
	@Size(message="El Carnet no debe ser mas grande que 10 caracteres",max=10)
	@NotEmpty(message="Campo Obligatorio")
	@Column(name="carne")
	private String Carnet;
	
	@Size(message="El nombre de la carrera debe ser mas grande que 50 caracteres",max=100)
	@NotEmpty(message="Campo Obligatorio")
	@Column(name="carrera")
	private String Carrera;

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCarnet() {
		return Carnet;
	}

	public void setCarnet(String carnet) {
		Carnet = carnet;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	//CONSTRUCTOR
		public Estudiante() {}
		
	
	
	
}
