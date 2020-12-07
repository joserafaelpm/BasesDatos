package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Domicilio;
import modelo.DomicilioDAO;

/**
 * Servlet implementation class DomicilioServlet
 */
@WebServlet("/DomicilioServlet/*")
public class DomicilioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DomicilioDAO dDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DomicilioServlet() {
		super();
		dDAO = new DomicilioDAO();
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
		String destino = request.getParameter("destino");
		Float precio = Float.parseFloat(request.getParameter("precio"));
		Domicilio d = new Domicilio();
		d.setDestino(destino);
		d.setPrecio(precio);
		dDAO.insert(d);
		request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Domicilio d = new Domicilio();
		d.setId(id);
		Domicilio aux = dDAO.find(d.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("domicilio", aux);
		request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Domicilio d = new Domicilio();
		Domicilio aux = dDAO.find(d.getId());
		d.setId(id);
		dDAO.delete(aux);
		request.getRequestDispatcher("listaDomicilio.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destino = request.getParameter("destino");
		Float precio = Float.parseFloat(request.getParameter("precio"));
		Domicilio d = new Domicilio();
		d.setDestino(destino);
		d.setPrecio(precio);
		// eDAO.update(obj);
		dDAO.update(d);
		request.getRequestDispatcher("listaDomicilio.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Domicilio d = new Domicilio();
		d.setId(id);
		Domicilio aux = dDAO.find(d.getId());
		request.getSession().setAttribute("domicilio", aux);
		request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
