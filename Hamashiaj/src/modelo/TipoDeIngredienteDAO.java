package modelo;

import entidades.Tipoingrediente;
import util.Conexion;
import util.GenericDAO;

public class TipoDeIngredienteDAO extends Conexion<Tipoingrediente> implements GenericDAO<Tipoingrediente> {

	 public TipoDeIngredienteDAO() { 
		 super(Tipoingrediente.class);
	 }

}
