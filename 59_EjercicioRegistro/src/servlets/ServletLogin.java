package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		GestorUsuario gu = new GestorUsuario();
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		if(gu.validar(usuario)) {
			response.sendRedirect("inicio.jsp?nombre=" + nombre);
		}else {
			response.sendRedirect("login.jsp?error=Usuario no existe o no coincide con el password");
		}
	}

}
