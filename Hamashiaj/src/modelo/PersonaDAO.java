package modelo;


import entidades.Persona;
import util.Conexion;
import util.GenericDAO;

public class PersonaDAO extends Conexion<Persona> implements GenericDAO<Persona> {

	 public PersonaDAO() { 
		 super(Persona.class);
	 }

}
