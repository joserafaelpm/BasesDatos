package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orden database table.
 * 
 */
@Entity
@NamedQuery(name="Orden.findAll", query="SELECT o FROM Orden o")
public class Orden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Camarero
	@ManyToOne
	private Camarero camarero;

	//bi-directional many-to-one association to Chef
	@ManyToOne
	private Chef chef;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cedula")
	private Cliente cliente;

	//bi-directional many-to-one association to Domicilio
	@ManyToOne
	private Domicilio domicilio;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	private Factura factura;

	//bi-directional many-to-one association to Ordenplatillo
	@OneToMany(mappedBy="orden")
	private List<Ordenplatillo> ordenplatillos;

	public Orden() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Camarero getCamarero() {
		return this.camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public Chef getChef() {
		return this.chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Domicilio getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Ordenplatillo> getOrdenplatillos() {
		return this.ordenplatillos;
	}

	public void setOrdenplatillos(List<Ordenplatillo> ordenplatillos) {
		this.ordenplatillos = ordenplatillos;
	}

	public Ordenplatillo addOrdenplatillo(Ordenplatillo ordenplatillo) {
		getOrdenplatillos().add(ordenplatillo);
		ordenplatillo.setOrden(this);

		return ordenplatillo;
	}

	public Ordenplatillo removeOrdenplatillo(Ordenplatillo ordenplatillo) {
		getOrdenplatillos().remove(ordenplatillo);
		ordenplatillo.setOrden(null);

		return ordenplatillo;
	}

}