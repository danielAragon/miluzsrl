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

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="transacciones")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long serial;
	
	@NotNull
	private String tipo;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Stock stock;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechacaducidad;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechahoratransaccion;
	
	@NotNull
	@Range(min=1, max=5000)
	private Integer cantidadtransaccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Date getFechacaducidad() {
		return fechacaducidad;
	}

	public void setFechacaducidad(Date fechacaducidad) {
		this.fechacaducidad = fechacaducidad;
	}

	public Date getFechahoratransaccion() {
		return fechahoratransaccion;
	}

	public void setFechahoratransaccion(Date fechahoratransaccion) {
		this.fechahoratransaccion = fechahoratransaccion;
	}

	public Integer getCantidadtransaccion() {
		return cantidadtransaccion;
	}

	public void setCantidadtransaccion(Integer cantidadtransaccion) {
		this.cantidadtransaccion = cantidadtransaccion;
	}
}
