package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoingrediente database table.
 * 
 */
@Entity
@Table(name="tipoingrediente")
@NamedQuery(name="Tipoingrediente.findAll", query="SELECT t FROM Tipoingrediente t")
public class Tipoingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Ingrediente
	@OneToMany(mappedBy="tipoingrediente")
	private List<Ingrediente> ingredientes;

	public Tipoingrediente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Ingrediente addIngrediente(Ingrediente ingrediente) {
		getIngredientes().add(ingrediente);
		ingrediente.setTipoingrediente(this);

		return ingrediente;
	}

	public Ingrediente removeIngrediente(Ingrediente ingrediente) {
		getIngredientes().remove(ingrediente);
		ingrediente.setTipoingrediente(null);

		return ingrediente;
	}

}