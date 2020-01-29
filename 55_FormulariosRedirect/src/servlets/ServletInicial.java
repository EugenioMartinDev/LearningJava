package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersona;

@WebServlet("/ServletInicial")
public class ServletInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por doGet");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		
		GestorPersona gp = new GestorPersona();
		boolean validada = gp.validar(persona);
		if(validada) {
			//ojo, aqui estamos haciendo un 300 (codigo http 
			//de respuesta) al navegador
			response.sendRedirect("principal.html");
		}else {
			response.sendRedirect("index.html");
		}	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por doPost");
		doGet(request, response);
	}

}
