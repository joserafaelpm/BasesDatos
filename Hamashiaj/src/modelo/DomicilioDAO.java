package modelo;

import entidades.Domicilio;
import util.GenericDAO;
import util.Conexion;

public class DomicilioDAO extends Conexion<Domicilio> implements GenericDAO<Domicilio> {

	public DomicilioDAO() {
		super(Domicilio.class);
	}

}
