package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;

/**
 * Servlet implementation class ServletFormulario
 */
@WebServlet("/ServletFormulario")
public class ServletFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String peso = request.getParameter("peso");
		Integer ipeso = Integer.parseInt(peso);
		
		System.out.println("Nombre : " + nombre + " Peso : " + ipeso);
		
		Double libras = ipeso * 0.45392;
		System.out.println("libras: " + libras);
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setPeso(Double.parseDouble(peso));
		persona.setLibras(libras);
		
		//Debemos introducir en la request los valores creados en doGet para que los conozca final.jsp
		request.setAttribute("librasConvertidas", libras);
		request.setAttribute("nombreUsuario", nombre);
		request.setAttribute("persona", persona);
		
		//Le decimos a JVM que siga la ejecución de esta request en "final.jsp" - cambio de contexto
		request.getRequestDispatcher("final.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
