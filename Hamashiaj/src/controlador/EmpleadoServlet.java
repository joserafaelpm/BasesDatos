package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Empleado;
import entidades.Persona;
import modelo.EmpleadoDAO;
import modelo.PersonaDAO;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpleadoDAO eDAO;
	private PersonaDAO pDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoServlet() {
		super();
		eDAO = new EmpleadoDAO();
		pDAO = new PersonaDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "eliminar":
			this.eliminar(request, response);
			break;
		case "mostrar":
			this.showForm(request, response);
			break;
		/*
		 * case "/buscar": this.buscar(request, response); break;
		 */
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "buscar":
			this.buscar(request, response);
			break;
		case "registrar":
			this.registrar(request, response);
			break;
		case "actualizar":
			this.actualizar(request, response);
			break;
		default:
			break;
		}
	}

	// metodos

	protected void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		String cargo = request.getParameter("cargo");
		Empleado e = new Empleado();
		Persona p = pDAO.find(cedula);
		e.setCargo(cargo);
		e.setPersona(p);
		// eDAO.update(obj);
		eDAO.insert(e);
		request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Empleado e = new Empleado();
		e.setId(id);
		Empleado aux = eDAO.find(e.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("empleado", aux);
		request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Empleado e = new Empleado();
		Empleado aux = eDAO.find(id);
		e.setId(id);
		eDAO.delete(aux);
		request.getRequestDispatcher("listaEmpleado.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		String cargo = request.getParameter("cargo");
		Empleado e = new Empleado();
		Persona p = pDAO.find(cedula);
		e.setCargo(cargo);
		e.setPersona(p);
		// eDAO.update(obj);
		eDAO.update(e);
		request.getRequestDispatcher("listaEmpleado.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Empleado e = new Empleado();
		e.setId(id);
		Empleado aux = eDAO.find(id);
		request.getSession().setAttribute("empleado", aux);
		request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
