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
public class Consumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int cantidad;
	
	@Column
	private String fechaconsumo;
	
	@Column
	private int horaconsumo;
	
	@Column
	private double descuento;
	
	@ManyToOne
	@JoinColumn(name="idoperador",nullable=false)
	private Operador operador;
	
	@ManyToOne
	@JoinColumn(name="idtipocombustible",nullable=false)
	private Tipocombustible tipocombustible;
	
	@ManyToOne
	@JoinColumn(name="idcliente",nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idvehiculo",nullable=false)
	private Vehiculo vehiculo;

	//==========================================================//
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaconsumo() {
		return fechaconsumo;
	}

	public void setFechaconsumo(String fechaconsumo) {
		this.fechaconsumo = fechaconsumo;
	}

	public int getHoraconsumo() {
		return horaconsumo;
	}

	public void setHoraconsumo(int horaconsumo) {
		this.horaconsumo = horaconsumo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Tipocombustible getTipocombustible() {
		return tipocombustible;
	}

	public void setTipocombustible(Tipocombustible tipocombustible) {
		this.tipocombustible = tipocombustible;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}
