package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the platillo database table.
 * 
 */
@Entity
@NamedQuery(name="Platillo.findAll", query="SELECT p FROM Platillo p")
public class Platillo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String descripcion;

	private String nombre;

	private float precio;

	@Column(name="url_imagen")
	private String urlImagen;

	//bi-directional many-to-one association to Adicional
	@OneToMany(mappedBy="platillo")
	private List<Adicional> adicionals;

	//bi-directional many-to-one association to Ingredientesplatillo
	@OneToMany(mappedBy="platillo")
	private List<Ingredientesplatillo> ingredientesplatillos;

	//bi-directional many-to-one association to Ordenplatillo
	@OneToMany(mappedBy="platillo")
	private List<Ordenplatillo> ordenplatillos;

	public Platillo() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getUrlImagen() {
		return this.urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public List<Adicional> getAdicionals() {
		return this.adicionals;
	}

	public void setAdicionals(List<Adicional> adicionals) {
		this.adicionals = adicionals;
	}

	public Adicional addAdicional(Adicional adicional) {
		getAdicionals().add(adicional);
		adicional.setPlatillo(this);

		return adicional;
	}

	public Adicional removeAdicional(Adicional adicional) {
		getAdicionals().remove(adicional);
		adicional.setPlatillo(null);

		return adicional;
	}

	public List<Ingredientesplatillo> getIngredientesplatillos() {
		return this.ingredientesplatillos;
	}

	public void setIngredientesplatillos(List<Ingredientesplatillo> ingredientesplatillos) {
		this.ingredientesplatillos = ingredientesplatillos;
	}

	public Ingredientesplatillo addIngredientesplatillo(Ingredientesplatillo ingredientesplatillo) {
		getIngredientesplatillos().add(ingredientesplatillo);
		ingredientesplatillo.setPlatillo(this);

		return ingredientesplatillo;
	}

	public Ingredientesplatillo removeIngredientesplatillo(Ingredientesplatillo ingredientesplatillo) {
		getIngredientesplatillos().remove(ingredientesplatillo);
		ingredientesplatillo.setPlatillo(null);

		return ingredientesplatillo;
	}

	public List<Ordenplatillo> getOrdenplatillos() {
		return this.ordenplatillos;
	}

	public void setOrdenplatillos(List<Ordenplatillo> ordenplatillos) {
		this.ordenplatillos = ordenplatillos;
	}

	public Ordenplatillo addOrdenplatillo(Ordenplatillo ordenplatillo) {
		getOrdenplatillos().add(ordenplatillo);
		ordenplatillo.setPlatillo(this);

		return ordenplatillo;
	}

	public Ordenplatillo removeOrdenplatillo(Ordenplatillo ordenplatillo) {
		getOrdenplatillos().remove(ordenplatillo);
		ordenplatillo.setPlatillo(null);

		return ordenplatillo;
	}

}