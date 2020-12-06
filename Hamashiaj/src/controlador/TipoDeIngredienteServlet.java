package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Tipoingrediente;
import modelo.TipoDeIngredienteDAO;

/**
 * Servlet implementation class TipoDeIngredienteServlet
 */
@WebServlet("/TipoDeIngredienteServlet/*")
public class TipoDeIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoDeIngredienteDAO tDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipoDeIngredienteServlet() {
		super();
		tDAO = new TipoDeIngredienteDAO();
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
		String descripcion = request.getParameter("descripcion");
		Tipoingrediente t = new Tipoingrediente();
		t.setDescripcion(descripcion);
		// eDAO.update(obj);
		tDAO.insert(t);
		request.getRequestDispatcher("registroTipoDeIngrediente.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tipoingrediente t = new Tipoingrediente();
		t.setId(id);
		Tipoingrediente aux = tDAO.find(t.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("tipoingrediente", aux);
		request.getRequestDispatcher("registroTipoDeIngrediente.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tipoingrediente t = new Tipoingrediente();
		Tipoingrediente aux = tDAO.find(id);
		t.setId(id);
		tDAO.delete(aux);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String descripcion = request.getParameter("descripcion");
		Tipoingrediente t = new Tipoingrediente();
		t.setDescripcion(descripcion);
		// eDAO.update(obj);
		tDAO.update(t);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tipoingrediente t = new Tipoingrediente();
		t.setId(id);
		Tipoingrediente aux = tDAO.find(t.getId());
		request.getSession().setAttribute("tipoingrediente", aux);
		request.getRequestDispatcher("registroTipoDeIngrediente.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
