package servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTableMultiplicar")
public class ServletTableMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mensaje = "";
		mensaje += "<html>";
		mensaje += "<head>";
		mensaje += "<title>Tabla Multiplicar</title>";
		mensaje += "<body>";
		mensaje += "<h1>Tabla de multiplicar</h1>";
		mensaje += "<table>";
		int numero = 7;
		for(int i=0;i<=10;i++) {
			mensaje += "<tr>";
			mensaje += "<td>" + numero + "</td>";
			mensaje += "<td>" + i + "</td>";
			mensaje += "<td>" + (numero*i) + "</td>";
			mensaje += "<tr>";
		}
		mensaje += "</table>";
		mensaje += "</body>";
		mensaje += "</html>";
		
		response.getWriter().append(mensaje);
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
