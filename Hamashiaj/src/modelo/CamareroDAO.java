package modelo;

import entidades.Camarero;
import util.GenericDAO;
import util.Conexion;

public class CamareroDAO extends Conexion<Camarero> implements GenericDAO<Camarero> {

	public CamareroDAO() {
		super(Camarero.class);
	}

}