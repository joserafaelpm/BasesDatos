package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String cargo;

	//bi-directional one-to-one association to Camarero
	@OneToOne(mappedBy="empleado")
	private Camarero camarero;

	//bi-directional one-to-one association to Chef
	@OneToOne(mappedBy="empleado")
	private Chef chef;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="cedula")
	private Persona persona;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}