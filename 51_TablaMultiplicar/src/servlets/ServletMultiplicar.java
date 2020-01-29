package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "";
		mensaje += "<html>";
		mensaje += "<head>";
		mensaje += "<title>Tabla multiplicar</title>";
		mensaje += "</head>";
		mensaje += "<body>";
		mensaje += "<h1>Tabla de multiplicar</h1>";
		mensaje += "<img src='img/batman.jpg'/>";
		mensaje += "<table>";
		int numero = 7;
		for(int i=0;i<=10;i++) {
			mensaje += "<tr>";
			mensaje += "<td>" + numero + "</td>";
			mensaje += "<td> * " + i + "</td>";
			mensaje += "<td> = " + (numero * i) + "</td>";
			mensaje += "</tr>";
		}
		mensaje += "</table>";
		
		response.getWriter().append(mensaje);
		response.setContentType("text/html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
