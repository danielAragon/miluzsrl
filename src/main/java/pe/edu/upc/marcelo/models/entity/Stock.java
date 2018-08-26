package pe.edu.upc.marcelo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import pe.edu.upc.marcelo.models.entity.Minimarket;
import pe.edu.upc.marcelo.models.entity.Producto;

@Entity
@Table(name="stocks")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="producto_id")
	@JsonBackReference
	private Producto producto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="minimarket_id")
	@JsonBackReference
	private Minimarket minimarket;
	
	@NotNull
	@Min(value=0, message="El valor del stock no puede ser menos a cero.")
	private Integer cantidadstock;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Transaccion> transacciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Minimarket getMinimarket() {
		return minimarket;
	}

	public void setMinimarket(Minimarket minimarket) {
		this.minimarket = minimarket;
	}

	public Integer getCantidadstock() {
		return cantidadstock;
	}

	public void setCantidadstock(Integer cantidadstock) {
		this.cantidadstock = cantidadstock;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public void addTransaccion(Transaccion transaccion) {
		this.transacciones.add(transaccion);
	}
}
