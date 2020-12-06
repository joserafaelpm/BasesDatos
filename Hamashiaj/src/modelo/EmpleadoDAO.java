package modelo;

import entidades.Empleado;
import util.Conexion;
import util.GenericDAO;

public class EmpleadoDAO extends Conexion<Empleado> implements GenericDAO<Empleado> {

public EmpleadoDAO() { 
	 super(Empleado.class);
}

}
