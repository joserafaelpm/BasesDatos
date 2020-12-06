package modelo;

import entidades.Chef;
import util.GenericDAO;
import util.Conexion;

public class ChefDAO extends Conexion<Chef> implements GenericDAO<Chef> {

	public ChefDAO() {
		super(Chef.class);
	}

}
