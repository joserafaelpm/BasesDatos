package modelo;

import entidades.Orden;
import util.GenericDAO;
import util.Conexion;

public class OrdenDAO extends Conexion<Orden> implements GenericDAO<Orden> {

	public OrdenDAO() {
		super(Orden.class);
	}

}