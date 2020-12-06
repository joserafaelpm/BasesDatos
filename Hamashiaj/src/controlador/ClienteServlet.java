package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Persona;
import modelo.ClienteDAO;
import modelo.PersonaDAO;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO cDAO;
	private PersonaDAO pDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        cDAO = new ClienteDAO();
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
		Cliente c = new Cliente();
		Persona p = pDAO.find(cedula);
		c.setCedula(p.getCedula());
		c.setPersona(p);
		cDAO.insert(c);
		request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		Cliente c = new Cliente();
		c.setCedula(cedula);
		Cliente aux = cDAO.find(c.getCedula());
		System.out.println(aux.getCedula());
		request.getSession().setAttribute("cliente", aux);
		request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cedula = request.getParameter("cedula");
		Cliente c = new Cliente();
		Cliente aux = cDAO.find(cedula);
		c.setCedula(cedula);;
		cDAO.delete(aux);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		Cliente c = new Cliente();
		Persona p = pDAO.find(cedula);
		c.setCedula(p.getCedula());
		c.setPersona(p);
		// eDAO.update(obj);
		cDAO.update(c);
		request.getRequestDispatcher("listaCliente.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		Cliente c = new Cliente();
		c.setCedula(cedula);
		Cliente aux = cDAO.find(c.getCedula());
		request.getSession().setAttribute("cliente", aux);
		request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
