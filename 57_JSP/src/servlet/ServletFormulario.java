package servlet;

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
       
    
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String peso = request.getParameter("peso");
		int iPeso = Integer.parseInt(peso);
		System.out.println(nombre);
		System.out.println(iPeso);
		
		double libras = iPeso * 0.453592;
		System.out.println("libras: " + libras);
		
		//creamos el objeto persona
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setPesoKilos(iPeso);
		p.setPesoLibras(libras);
		
		//tenemos que meter en la request los valores que 
		//queramos pasarle a nuestro jsp
		request.setAttribute("l", libras);
		request.setAttribute("n", nombre);
		request.setAttribute("persona", p);
		//Con esta sentencia le decimos a java que siga con 
		//la ejecución de esta request en el jsp final.jsp
		//en cuanto salga de este metodo (doGet) ira a ejecutar
		//el final.jsp
		request.getRequestDispatcher("final.jsp").
			forward(request, response);

	}

	
}
