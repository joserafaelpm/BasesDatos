package modelo;

import entidades.Cliente;
import util.Conexion;
import util.GenericDAO;

public class ClienteDAO extends Conexion<Cliente> implements GenericDAO<Cliente> {
	 public ClienteDAO() { 
		 super(Cliente.class);
	 }

}
