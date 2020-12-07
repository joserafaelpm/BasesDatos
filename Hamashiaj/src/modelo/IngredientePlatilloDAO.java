package modelo;


import entidades.Ingredientesplatillo;
import util.Conexion;
import util.GenericDAO;

public class IngredientePlatilloDAO extends Conexion<Ingredientesplatillo> implements GenericDAO<Ingredientesplatillo> {

	 public IngredientePlatilloDAO() { 
		 super(Ingredientesplatillo.class);
	 }

}
