package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;

/**
 * Servlet implementation class ServletDetalle
 */
@WebServlet("/detalle")
public class ServletDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		//Aquí habría que llamar al gestor, y el gestor al DAO
		usuario.setEdad("38");
		usuario.setPeso("89");
		
		request.setAttribute("u", usuario);
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
			
	}

}
