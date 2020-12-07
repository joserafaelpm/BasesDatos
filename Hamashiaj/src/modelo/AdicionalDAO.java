package modelo;

import entidades.Adicional;
import util.GenericDAO;
import util.Conexion;

public class AdicionalDAO extends Conexion<Adicional> implements GenericDAO<Adicional> {

	public AdicionalDAO() {
		super(Adicional.class);
	}

}