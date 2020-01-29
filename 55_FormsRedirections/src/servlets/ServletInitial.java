package servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersonas;

/**
 * Servlet implementation class ServletInitial
 */
@WebServlet("/ServletInitial")  //Contiene la url, que es un directorio virtual. Podríamos poner /miDirectorioVirtualCabeza/ServletInitial)
public class ServletInitial extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInitial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por doGet");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		
		GestorPersonas gp = new GestorPersonas();
		boolean validada = gp.validar(persona);
		
		if (validada) {
			// sendRedirect implementa un código 300 al navegador
			response.sendRedirect("principal.html");
		} else {
			response.sendRedirect("index.html");
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());  // getWriter rellana el body -en condiciones normalels esto es un 200OK
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por doPost");
		//doGet(request, response);
	}

}
