package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chef database table.
 * 
 */
@Entity
@Table(name="chef")
@NamedQuery(name="Chef.findAll", query="SELECT c FROM Chef c")
public class Chef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumn(name="id")
	private Empleado empleado;

	//bi-directional many-to-one association to Orden
	@OneToMany(mappedBy="chef")
	private List<Orden> ordens;

	public Chef() {
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
		orden.setChef(this);

		return orden;
	}

	public Orden removeOrden(Orden orden) {
		getOrdens().remove(orden);
		orden.setChef(null);

		return orden;
	}

}