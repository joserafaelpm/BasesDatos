package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Camarero;
import entidades.Chef;
import entidades.Cliente;
import entidades.Domicilio;
import entidades.Orden;
import entidades.Persona;
import modelo.CamareroDAO;
import modelo.ChefDAO;
import modelo.ClienteDAO;
import modelo.DomicilioDAO;
import modelo.OrdenDAO;

/**
 * Servlet implementation class OrdenServlet
 */
@WebServlet("/OrdenServlet/*")
public class OrdenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdenDAO oDAO;
	private ChefDAO chDAO;
	private CamareroDAO camaDAO;
	private DomicilioDAO dDAO;
	private ClienteDAO clienteDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdenServlet() {
		super();
		oDAO = new OrdenDAO();
		chDAO = new ChefDAO();
		camaDAO = new CamareroDAO();
		dDAO = new DomicilioDAO();
		clienteDAO = new ClienteDAO();
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
		Integer chefid = Integer.parseInt(request.getParameter("chefid"));
		Integer camareroid = Integer.parseInt(request.getParameter("camareroid"));
		Integer domicilioid = Integer.parseInt(request.getParameter("domicilioid"));
		Orden o = new Orden();
		Cliente clie = clienteDAO.find(cedula);
		Chef c = chDAO.find(chefid);
		Camarero cama = camaDAO.find(camareroid);
		Domicilio d = dDAO.find(domicilioid);
		o.setCamarero(cama);
		o.setChef(c);
		o.setDomicilio(d);
		o.setCliente(clie);
		// eDAO.update(obj);
		oDAO.insert(o);
		request.getRequestDispatcher("registroOrden.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Orden o = new Orden();
		o.setId(id);
		Orden aux = oDAO.find(o.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("orden", aux);
		request.getRequestDispatcher("registroOrden.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Orden o = new Orden();
		Orden aux = oDAO.find(o.getId());
		o.setId(id);
		oDAO.delete(aux);
		request.getRequestDispatcher("listaOrden.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		Integer chefid = Integer.parseInt(request.getParameter("chefid"));
		Integer camareroid = Integer.parseInt(request.getParameter("camareroid"));
		Integer domicilioid = Integer.parseInt(request.getParameter("domicilioid"));
		Orden o = new Orden();
		Cliente clie = clienteDAO.find(cedula);
		Chef c = chDAO.find(chefid);
		Camarero cama = camaDAO.find(camareroid);
		Domicilio d = dDAO.find(domicilioid);
		o.setCamarero(cama);
		o.setChef(c);
		o.setDomicilio(d);
		o.setCliente(clie);
		// eDAO.update(obj);
		oDAO.update(o);
		request.getRequestDispatcher("listaOrden.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Orden o = new Orden();
		o.setId(id);
		Orden aux = oDAO.find(o.getId());
		request.getSession().setAttribute("orden", aux);
		request.getRequestDispatcher("registroOrden.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
