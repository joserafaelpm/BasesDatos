package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Domicilio;
import entidades.Ingrediente;
import entidades.Ingredientesplatillo;
import entidades.IngredientesplatilloPK;
import entidades.Platillo;
import modelo.IngredienteDAO;
import modelo.IngredientePlatilloDAO;
import modelo.IngredientesplatillopkDAO;
import modelo.PlatilloDAO;

/**
 * Servlet implementation class IngredientePlatilloServlet
 */
@WebServlet("/IngredientePlatilloServlet/*")
public class IngredientePlatilloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IngredientePlatilloDAO iDAO;
	private IngredienteDAO ingreDAO;
	private PlatilloDAO pDAO;
	private IngredientesplatillopkDAO ipkDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IngredientePlatilloServlet() {
		super();
		iDAO = new IngredientePlatilloDAO();
		ingreDAO = new IngredienteDAO();
		pDAO = new PlatilloDAO();
		ipkDAO = new IngredientesplatillopkDAO();
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
		Integer ingredienteId = Integer.parseInt(request.getParameter("ingredienteId"));
		Integer platilloId = Integer.parseInt(request.getParameter("platilloId"));
		Integer peso = Integer.parseInt(request.getParameter("peso"));
		Ingrediente ingre = ingreDAO.find(ingredienteId);
		Platillo p = pDAO.find(platilloId);
		Ingredientesplatillo i = new Ingredientesplatillo();
		i.setIngrediente(ingre);
		i.setPlatillo(p);
		i.setPeso(peso);
		iDAO.insert(i);
		request.getRequestDispatcher("registroIngredientePlatillo.jsp").forward(request, response);
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//IngredientesplatilloPK id = request.getParameter("id");
	//	IngredientesplatilloPK aux = (IngredientesplatilloPK) id;
		//Ingredientesplatillo i = iDAO.find(aux);
		//iDAO.delete(i);
		// iDAO.delete();
		request.getRequestDispatcher("listaIngredientePlatillo.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer ingredienteId = Integer.parseInt(request.getParameter("ingredienteId"));
		Integer platilloId = Integer.parseInt(request.getParameter("platilloId"));
		Integer peso = Integer.parseInt(request.getParameter("peso"));
		Ingrediente ingre = ingreDAO.find(ingredienteId);
		Platillo p = pDAO.find(platilloId);
		Ingredientesplatillo i = new Ingredientesplatillo();
		i.setIngrediente(ingre);
		i.setPlatillo(p);
		i.setPeso(peso);
		// eDAO.update(obj);
		iDAO.update(i);
		request.getRequestDispatcher("listaIngredientePlatillo.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
