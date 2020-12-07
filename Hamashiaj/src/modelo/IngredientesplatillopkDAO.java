package modelo;


import entidades.IngredientesplatilloPK;
import util.Conexion;
import util.GenericDAO;

public class IngredientesplatillopkDAO extends Conexion<IngredientesplatilloPK> implements GenericDAO<IngredientesplatilloPK> {

	 public IngredientesplatillopkDAO() { 
		 super(IngredientesplatilloPK.class);
	 }

}
