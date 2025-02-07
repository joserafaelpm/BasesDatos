package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingredientesplatillo database table.
 * 
 */
@Entity
@Table(name="ingredientesplatillo")
@NamedQuery(name="Ingredientesplatillo.findAll", query="SELECT i FROM Ingredientesplatillo i")
public class Ingredientesplatillo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private IngredientesplatilloPK id;

	private int peso;

	//bi-directional many-to-one association to Ingrediente
	@JoinColumn(name="ingrediente_id", insertable=false, updatable=false)
	@ManyToOne
	private Ingrediente ingrediente;

	//bi-directional many-to-one association to Platillo
	@JoinColumn(name="platillo_id", insertable=false, updatable=false)
	@ManyToOne
	private Platillo platillo;

	public Ingredientesplatillo() {
	}

	public IngredientesplatilloPK getId() {
		return this.id;
	}

	public void setId(IngredientesplatilloPK id) {
		this.id = id;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Ingrediente getIngrediente() {
		return this.ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Platillo getPlatillo() {
		return this.platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

}