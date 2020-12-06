package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Ingrediente;
import entidades.Tipoingrediente;
import modelo.IngredienteDAO;
import modelo.TipoDeIngredienteDAO;

/**
 * Servlet implementation class IngredienteServlet
 */
@WebServlet("/IngredienteServlet/*")
public class IngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IngredienteDAO  iDAO;
    private TipoDeIngredienteDAO  tDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredienteServlet() {
        super();
        iDAO = new IngredienteDAO();
        tDAO = new TipoDeIngredienteDAO();
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
	
	// metodos

		protected void registrar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String nombre = request.getParameter("nombre");
			Integer tipoingredienteid = Integer.parseInt(request.getParameter("tipoingredienteid"));
			Ingrediente i = new Ingrediente();
			Tipoingrediente t = tDAO.find(tipoingredienteid);
			i.setNombre(nombre);
			i.setTipoingrediente(t);
			//i.setTipoingrediente(tipoingredienteid);;
			// eDAO.update(obj);
			iDAO.insert(i);
			request.getRequestDispatcher("registroIngrediente.jsp").forward(request, response);
		}

		protected void buscar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));
			Ingrediente i = new Ingrediente();
			i.setId(id);
			Ingrediente aux = iDAO.find(i.getId());
			System.out.println(aux.getId());
			request.getSession().setAttribute("ingrediente", aux);
			request.getRequestDispatcher("registroIngrediente.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado");
		}

		protected void eliminar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Ingrediente i = new Ingrediente();
			Ingrediente aux = iDAO.find(id);
			i.setId(id);
			iDAO.delete(aux);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		}

		protected void actualizar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String nombre = request.getParameter("nombre");
			Integer tipoingredienteid = Integer.parseInt(request.getParameter("tipoingredienteid"));
			Ingrediente i = new Ingrediente();
			Tipoingrediente t = tDAO.find(tipoingredienteid);
			i.setNombre(nombre);
			i.setTipoingrediente(t);
			// eDAO.update(obj);
			iDAO.update(i);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		}

		protected void showForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));
			Ingrediente i = new Ingrediente();
			i.setId(id);
			Ingrediente aux = iDAO.find(i.getId());
			request.getSession().setAttribute("ingrediente", aux);
			request.getRequestDispatcher("registroIngrediente.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado.jsp");
		}

}
