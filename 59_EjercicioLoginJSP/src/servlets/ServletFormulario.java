package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Login;
import modelo.negocio.GestorLogin;

@WebServlet("/ServletFormulario")
public class ServletFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger los parametros
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		
		//Segundo, formar el objeto que vamos a usar
		Login login = new Login();
		login.setUsuario(usuario);
		login.setContraseña(contraseña);

		GestorLogin gp = new GestorLogin();
		boolean validado = gp.validar(login);
		
		if(validado) {
			System.out.println("Login validado: " + login);
			request.setAttribute("login", login);
			request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
		}else {
			System.out.println("Pedido NO validado: " + login);
			//Esto puede ser una menera, el problema es que no cambia
			//la url a "formulario.jsp", entonces si ser recarga
			//la pagina se volveria a mandar le formulario
			//request.setAttribute("error", "No ha relleando adecuadamente el formulario");
			//request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
			//Siempre que se envie un formulario se deberia hacer
			//un redirect en vez de un forward
			response.sendRedirect("formulario.jsp?error=No ha rellenado adecuadamente el formulario");
		}
	}

}
