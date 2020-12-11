package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ordenplatillo database table.
 * 
 */
@Entity
@Table(name="ordenplatillo")
@NamedQuery(name="Ordenplatillo.findAll", query="SELECT o FROM Ordenplatillo o")
public class Ordenplatillo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdenplatilloPK id;

	private String cantidad;

	private float precio;

	//bi-directional many-to-one association to Orden
	@JoinColumn(name="orden_id", insertable=false, updatable=false)
	@ManyToOne
	private Orden orden;

	//bi-directional many-to-one association to Platillo
	@JoinColumn(name="platillo_id", insertable=false, updatable=false)
	@ManyToOne
	private Platillo platillo;

	public Ordenplatillo() {
	}

	public OrdenplatilloPK getId() {
		return this.id;
	}

	public void setId(OrdenplatilloPK id) {
		this.id = id;
	}

	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Orden getOrden() {
		return this.orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Platillo getPlatillo() {
		return this.platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

}