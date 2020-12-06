package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import modelo.PersonaDAO;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet/*")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO pDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        pDAO = new PersonaDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "eliminar":
			this.eliminar(request, response);
			break;
		case "mostrar":
			this.showForm(request, response);
			break;
			/*	case "/buscar":
			this.buscar(request, response);
			break;	 */
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	//metodos
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String cedula = request.getParameter("cedula");
		String direccion = request.getParameter("direccion");
		String genero = request.getParameter("genero");
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		Persona p = new Persona();
		p.setCedula(cedula);
		p.setDireccion(direccion);
		p.setGenero(genero);
		p.setNombre(nombre);
		p.setTelefono(telefono);
		// eDAO.update(obj);
		pDAO.insert(p);
		request.getRequestDispatcher("registroPersona.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		Persona p = new Persona();
		p.setCedula(cedula);
		Persona aux = pDAO.find(p.getCedula());
	    System.out.println(aux.getCedula());
		request.getSession().setAttribute("persona", aux);
		request.getRequestDispatcher("registroPersona.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cedula = request.getParameter("cedula");
		Persona p = new Persona();
		Persona aux = pDAO.find(cedula);
		p.setCedula(cedula);
		pDAO.delete(aux);
		request.getRequestDispatcher("listaPersona.jsp").forward(request, response);
	}
	
	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		String direccion = request.getParameter("direccion");
		String genero = request.getParameter("genero");
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		Persona p = new Persona();
		p.setCedula(cedula);
		p.setDireccion(direccion);
		p.setGenero(genero);
		p.setNombre(nombre);
		p.setTelefono(telefono);
		// eDAO.update(obj);
		pDAO.update(p);
		request.getRequestDispatcher("listaPersona.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				String cedula = request.getParameter("cedula");
				Persona p = new Persona();
				p.setCedula(cedula);
				Persona aux = pDAO.find(p.getCedula());
				request.getSession().setAttribute("persona", aux);
				request.getRequestDispatcher("registroPersona.jsp").forward(request, response);
			//	response.sendRedirect("registroEmpleado.jsp");
	}

}
