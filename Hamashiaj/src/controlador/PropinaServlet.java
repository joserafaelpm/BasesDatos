package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Camarero;
import entidades.Empleado;
import entidades.Propina;
import modelo.CamareroDAO;
import modelo.PropinaDAO;

/**
 * Servlet implementation class PropinaServlet
 */
@WebServlet("/PropinaServlet/*")
public class PropinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PropinaDAO pDAO;
    private CamareroDAO cDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropinaServlet() {
        super();
        cDAO = new CamareroDAO();
        pDAO = new PropinaDAO();
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
				Integer camareroid = Integer.parseInt(request.getParameter("id"));
				Float propina = Float.parseFloat(request.getParameter("propina"));
				String fechahora = request.getParameter("fechahora");
				//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				Camarero c = cDAO.find(camareroid);
				Propina p = new Propina();
				p.setPropina(propina);
				p.setCamarero(c);
				try {
	//				p.setFechahora(fechahora);
				}catch (Exception e) {
					// TODO: handle exception
				}
				// eDAO.update(obj);
				cDAO.insert(c);
				request.getRequestDispatcher("registroCamarero.jsp").forward(request, response);
			}

			protected void buscar(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				Integer id = Integer.parseInt(request.getParameter("id"));
				Camarero c = new Camarero();
				c.setId(id);
				Camarero aux = cDAO.find(c.getId());
				System.out.println(aux.getId());
				request.getSession().setAttribute("camarero", aux);
				request.getRequestDispatcher("registroCamarero.jsp").forward(request, response);
				// response.sendRedirect("registroEmpleado");
			}

			protected void eliminar(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				Integer id = Integer.parseInt(request.getParameter("id"));
				Camarero c = new Camarero();
				Camarero aux = cDAO.find(id);
				c.setId(id);
				cDAO.delete(aux);
				request.getRequestDispatcher("listaCamarero.jsp").forward(request, response);
			}

			protected void actualizar(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				Integer id = Integer.parseInt(request.getParameter("id"));
				Camarero c = new Camarero();
				c.setId(c.getId());
				// eDAO.update(obj);
				cDAO.update(c);
				request.getRequestDispatcher("listaCamarero.jsp").forward(request, response);
			}

			protected void showForm(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				Integer id = Integer.parseInt(request.getParameter("id"));
				Camarero c = new Camarero();
				c.setId(id);
				Camarero aux = cDAO.find(id);
				request.getSession().setAttribute("camarero", aux);
				request.getRequestDispatcher("registroCamarero.jsp").forward(request, response);
				// response.sendRedirect("registroEmpleado.jsp");
			}


}
