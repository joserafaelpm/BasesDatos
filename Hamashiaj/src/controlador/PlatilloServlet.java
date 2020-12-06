package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Platillo;
import modelo.PlatilloDAO;

/**
 * Servlet implementation class PlatilloServlet
 */
@WebServlet("/PlatilloServlet/*")
public class PlatilloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PlatilloDAO pDAO;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlatilloServlet() {
        super();
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
			String nombre = request.getParameter("nombre");
			Float precio = Float.parseFloat(request.getParameter("precio"));
			String descripcion = request.getParameter("descripcion");
			String url = request.getParameter("url");
			Platillo p = new Platillo();
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setDescripcion(descripcion);
			p.setUrlImagen(url);
			pDAO.insert(p);
			request.getRequestDispatcher("registroPlatillo.jsp").forward(request, response);
		}

		protected void buscar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));
			Platillo p = new Platillo();
			p.setId(id);
			Platillo aux = pDAO.find(p.getId());
			System.out.println(aux.getId());
			request.getSession().setAttribute("platillo", aux);
			request.getRequestDispatcher("registroPlatillo.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado");
		}

		protected void eliminar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Integer id = Integer.parseInt(request.getParameter("cedula"));
			Platillo p = new Platillo();
			Platillo aux = pDAO.find(id);
			p.setId(id);
			pDAO.delete(aux);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		}

		protected void actualizar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String nombre = request.getParameter("nombre");
			Float precio = Float.parseFloat(request.getParameter("precio"));
			String descripcion = request.getParameter("descripcion");
			String url = request.getParameter("url");
			Platillo p = new Platillo();
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setDescripcion(descripcion);
			p.setUrlImagen(url);
			// eDAO.update(obj);
			pDAO.update(p);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		}

		protected void showForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("cedula"));
			Platillo p = new Platillo();
			p.setId(id);
			Platillo aux = pDAO.find(p.getId());
			request.getSession().setAttribute("platillo", aux);
			request.getRequestDispatcher("registroPlatillo.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado.jsp");
		}

}
