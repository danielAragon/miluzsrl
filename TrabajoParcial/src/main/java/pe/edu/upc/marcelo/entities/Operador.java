package pe.edu.upc.marcelo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String ci;
	
	@Column
	private String telefono;
	
	@Column
	private String direccion;
	
	@Column
	private int horaingreso;
	
	@Column
	private int horasalida;
	
	@Column
	private int numplataforma;
	
	@Column
	private double comision;
	
	@ManyToOne
	@JoinColumn(name="idgrifo",nullable=false)
	private Grifo grifo;

	//==========================================================//
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getHoraingreso() {
		return horaingreso;
	}

	public void setHoraingreso(int horaingreso) {
		this.horaingreso = horaingreso;
	}

	public int getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(int horasalida) {
		this.horasalida = horasalida;
	}

	public int getNumplataforma() {
		return numplataforma;
	}

	public void setNumplataforma(int numplataforma) {
		this.numplataforma = numplataforma;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public Grifo getGrifo() {
		return grifo;
	}

	public void setGrifo(Grifo grifo) {
		this.grifo = grifo;
	}
}
