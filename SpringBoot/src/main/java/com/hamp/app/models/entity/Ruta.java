package com.hamp.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Ruta")
public class Ruta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String Ruta_ID;
	
	@NotEmpty
	private String Nombre;

	public String getRuta_ID() {
		return Ruta_ID;
	}

	public void setRuta_ID(String iD) {
		Ruta_ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

}
