package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Domicilio;
import modelo.AdicionalDAO;
import modelo.IngredienteDAO;
import modelo.PlatilloDAO;

/**
 * Servlet implementation class AdicionalServlet
 */
@WebServlet("/AdicionalServlet")
public class AdicionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdicionalDAO aDAO;
    private IngredienteDAO ingreDAO;
    private PlatilloDAO pDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionalServlet() {
        super();
        aDAO = new AdicionalDAO();
        ingreDAO = new IngredienteDAO();
        pDAO = new PlatilloDAO();
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
		
			request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
		}

		protected void buscar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
		
			request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado");
		}

		protected void eliminar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			request.getRequestDispatcher("listaDomicilio.jsp").forward(request, response);
		}

		protected void actualizar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			request.getRequestDispatcher("listaDomicilio.jsp").forward(request, response);
		}

		protected void showForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			request.getRequestDispatcher("registroDomicilio.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado.jsp");
		}
	
}