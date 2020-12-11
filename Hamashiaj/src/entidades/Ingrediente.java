package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ingrediente database table.
 * 
 */
@Entity
@Table(name="ingrediente")
@NamedQuery(name="Ingrediente.findAll", query="SELECT i FROM Ingrediente i")
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Adicional
	@OneToMany(mappedBy="ingrediente")
	private List<Adicional> adicionals;

	//bi-directional many-to-one association to Tipoingrediente
	@ManyToOne
	@JoinColumn(name="tipo_ingrediente_id")
	private Tipoingrediente tipoingrediente;

	//bi-directional many-to-one association to Ingredientesplatillo
	@OneToMany(mappedBy="ingrediente")
	private List<Ingredientesplatillo> ingredientesplatillos;

	public Ingrediente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Adicional> getAdicionals() {
		return this.adicionals;
	}

	public void setAdicionals(List<Adicional> adicionals) {
		this.adicionals = adicionals;
	}

	public Adicional addAdicional(Adicional adicional) {
		getAdicionals().add(adicional);
		adicional.setIngrediente(this);

		return adicional;
	}

	public Adicional removeAdicional(Adicional adicional) {
		getAdicionals().remove(adicional);
		adicional.setIngrediente(null);

		return adicional;
	}

	public Tipoingrediente getTipoingrediente() {
		return this.tipoingrediente;
	}

	public void setTipoingrediente(Tipoingrediente tipoingrediente) {
		this.tipoingrediente = tipoingrediente;
	}

	public List<Ingredientesplatillo> getIngredientesplatillos() {
		return this.ingredientesplatillos;
	}

	public void setIngredientesplatillos(List<Ingredientesplatillo> ingredientesplatillos) {
		this.ingredientesplatillos = ingredientesplatillos;
	}

	public Ingredientesplatillo addIngredientesplatillo(Ingredientesplatillo ingredientesplatillo) {
		getIngredientesplatillos().add(ingredientesplatillo);
		ingredientesplatillo.setIngrediente(this);

		return ingredientesplatillo;
	}

	public Ingredientesplatillo removeIngredientesplatillo(Ingredientesplatillo ingredientesplatillo) {
		getIngredientesplatillos().remove(ingredientesplatillo);
		ingredientesplatillo.setIngrediente(null);

		return ingredientesplatillo;
	}

}