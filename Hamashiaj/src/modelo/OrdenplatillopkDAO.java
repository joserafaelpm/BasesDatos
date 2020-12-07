package modelo;


import entidades.OrdenplatilloPK;
import util.Conexion;
import util.GenericDAO;

public class OrdenplatillopkDAO extends Conexion<OrdenplatilloPK> implements GenericDAO<OrdenplatilloPK> {

	 public OrdenplatillopkDAO() { 
		 super(OrdenplatilloPK.class);
	 }

}