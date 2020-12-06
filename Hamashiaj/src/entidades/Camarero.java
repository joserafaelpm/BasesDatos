package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the camarero database table.
 * 
 */
@Entity
@NamedQuery(name="Camarero.findAll", query="SELECT c FROM Camarero c")
public class Camarero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumn(name="id")
	private Empleado empleado;

	//bi-directional many-to-one association to Orden
	@OneToMany(mappedBy="camarero")
	private List<Orden> ordens;

	//bi-directional many-to-one association to Propina
	@OneToMany(mappedBy="camarero")
	private List<Propina> propinas;

	public Camarero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Orden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(List<Orden> ordens) {
		this.ordens = ordens;
	}

	public Orden addOrden(Orden orden) {
		getOrdens().add(orden);
		orden.setCamarero(this);

		return orden;
	}

	public Orden removeOrden(Orden orden) {
		getOrdens().remove(orden);
		orden.setCamarero(null);

		return orden;
	}

	public List<Propina> getPropinas() {
		return this.propinas;
	}

	public void setPropinas(List<Propina> propinas) {
		this.propinas = propinas;
	}

	public Propina addPropina(Propina propina) {
		getPropinas().add(propina);
		propina.setCamarero(this);

		return propina;
	}

	public Propina removePropina(Propina propina) {
		getPropinas().remove(propina);
		propina.setCamarero(null);

		return propina;
	}

}