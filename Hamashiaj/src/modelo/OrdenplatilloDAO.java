package modelo;


import entidades.Ordenplatillo;
import util.Conexion;
import util.GenericDAO;

public class OrdenplatilloDAO extends Conexion<Ordenplatillo> implements GenericDAO<Ordenplatillo> {

	 public OrdenplatilloDAO() { 
		 super(Ordenplatillo.class);
	 }

}