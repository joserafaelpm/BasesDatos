package modelo;

import entidades.Ingrediente;
import util.Conexion;
import util.GenericDAO;

public class IngredienteDAO extends Conexion<Ingrediente> implements GenericDAO<Ingrediente> {
	 public IngredienteDAO() { 
		 super(Ingrediente.class);
	 }
}
