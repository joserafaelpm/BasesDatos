package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Ingrediente;
import entidades.Ingredientesplatillo;
import entidades.IngredientesplatilloPK;
import entidades.Platillo;
import modelo.IngredientePlatilloDAO;
import modelo.OrdenDAO;
import modelo.OrdenplatilloDAO;
import modelo.OrdenplatillopkDAO;
import modelo.PlatilloDAO;

/**
 * Servlet implementation class OrdenPlatilloServlet
 */
@WebServlet("/OrdenPlatilloServlet")
public class OrdenplatilloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdenplatilloDAO opDAO;
    private PlatilloDAO pDAO;
    private OrdenDAO oDAO;
    private OrdenplatillopkDAO pkDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenplatilloServlet() {
        super();
        opDAO = new OrdenplatilloDAO();
        pDAO = new PlatilloDAO();
        oDAO = new OrdenDAO();
        pkDAO = new OrdenplatillopkDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			Integer ordenId = Integer.parseInt(request.getParameter("ordenId"));
			Integer platilloId = Integer.parseInt(request.getParameter("platilloId"));
			Float precio = Float.parseFloat(request.getParameter("precio"));
			Ingrediente ingre = ingreDAO.find(ingredienteId);
			Platillo p = pDAO.find(platilloId);
			Ingredientesplatillo i = new Ingredientesplatillo();
			IngredientesplatilloPK pk=new IngredientesplatilloPK();
			pk.setIngredienteId(ingredienteId);
			pk.setPlatilloId(platilloId);
			i.setIngrediente(ingre);
			i.setPlatillo(p);
			i.setPeso(peso);
			i.setId(pk);
			iDAO.insert(i);
			request.getRequestDispatcher("registroIngredientePlatillo.jsp").forward(request, response);
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
			IngredientesplatilloPK pk=new IngredientesplatilloPK();
			pk.setIngredienteId(ingredienteId);
			pk.setPlatilloId(platilloId);
			i.setIngrediente(ingre);
			i.setPlatillo(p);
			i.setPeso(peso);
			i.setId(pk);
			// eDAO.update(obj);
			iDAO.update(i);
			request.getRequestDispatcher("listaIngredientePlatillo.jsp").forward(request, response);
		}

		protected void showForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer ingredienteId = Integer.parseInt(request.getParameter("ingredienteId"));
			Integer platilloId = Integer.parseInt(request.getParameter("platilloId"));
			IngredientesplatilloPK pk=new IngredientesplatilloPK();
			pk.setIngredienteId(ingredienteId);
			pk.setPlatilloId(platilloId);
			Ingredientesplatillo i = new Ingredientesplatillo();
			i.setId(pk);
			Ingredientesplatillo iaux = new Ingredientesplatillo();
			request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado.jsp");
		}
	
}
