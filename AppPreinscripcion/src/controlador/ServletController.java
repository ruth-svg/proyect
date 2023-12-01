package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TitulosDAO;
import entidades.Preinscripciones;
import entidades.Titulos;
import ln.PreinscripcionesLN;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bGrabar = request.getParameter("grabar");
		String bVolver = request.getParameter("volver");
		boolean error = false;
		String envia = "";
		try {

			if (bGrabar != null) {
				String dni = request.getParameter("dni");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String fecha = request.getParameter("fecha");
				String titulo = request.getParameter("titulo");
				System.out.println(titulo);
				if (!titulo.equalsIgnoreCase("(ELIGE TITULO)") && !fecha.equalsIgnoreCase("dd/mm/aaaa")) {
					Titulos t = new Titulos();
					t.setCodtitulo(titulo);
					// Llamada al DAO
					t = TitulosDAO.select(t);
					Preinscripciones p = new Preinscripciones(dni, t, nombre, apellidos, fecha);
					// Llamada a LN
					String mensaje = PreinscripcionesLN.alta(p);
					request.setAttribute("mensaje", mensaje);
					envia = "Mensaje.jsp";
				} else { //
					request.setAttribute("mensaje", "(*)REVISE FECHA Y/O TÍTULO");
					envia = "Preinscripcion.jsp";
				}
				
			} else if (bVolver != null) {
				envia = "Preinscripcion.jsp";
			}
		} catch (Exception ex) {
			request.setAttribute("mensaje", "Ha ocurrido un error al grabar la preinscripción");
			ex.printStackTrace();
		} finally {

			request.getRequestDispatcher(envia).forward(request, response);
		}
	}

}
