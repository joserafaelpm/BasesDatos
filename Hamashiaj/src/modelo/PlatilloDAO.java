package modelo;

import entidades.Platillo;
import util.Conexion;
import util.GenericDAO;

public class PlatilloDAO  extends Conexion<Platillo> implements GenericDAO<Platillo> {

	 public PlatilloDAO() { 
		 super(Platillo.class);
	 } 

}


/* extends Conexion<entidad> implements GenericDAO<entidad> {

	 public classDAO() { 
		 super(entidad.class);
	 }  */
