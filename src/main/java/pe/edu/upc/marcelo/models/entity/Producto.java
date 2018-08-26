package pe.edu.upc.marcelo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import pe.edu.upc.marcelo.models.entity.Categoria;
import pe.edu.upc.marcelo.models.entity.Proveedor;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechavencimiento;
	
	@NotNull
	private Double preciocompra;

	@NotNull
	private Double precioventa;


	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Proveedor proveedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Double getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(Double preciocompra) {
		this.preciocompra = preciocompra;
	}

	public Double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
