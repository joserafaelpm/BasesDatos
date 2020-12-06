package modelo;

import entidades.Propina;
import util.Conexion;
import util.GenericDAO;

public class PropinaDAO  extends Conexion<Propina> implements GenericDAO<Propina> {

	 public PropinaDAO() { 
		 super(Propina.class);
	 } 

}


/* extends Conexion<entidad> implements GenericDAO<entidad> {

	 public classDAO() { 
		 super(entidad.class);
	 }  */
