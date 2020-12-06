package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the adicional database table.
 * 
 */
@Entity
@NamedQuery(name="Adicional.findAll", query="SELECT a FROM Adicional a")
public class Adicional implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AdicionalPK id;

	private float precio;

	//bi-directional many-to-one association to Ingrediente
	@JoinColumn(name="ingrediente_id", insertable=false, updatable=false)
	@ManyToOne
	private Ingrediente ingrediente;

	//bi-directional many-to-one association to Platillo
	@JoinColumn(name="platillo_id", insertable=false, updatable=false)
	@ManyToOne
	private Platillo platillo;

	public Adicional() {
	}

	public AdicionalPK getId() {
		return this.id;
	}

	public void setId(AdicionalPK id) {
		this.id = id;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
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