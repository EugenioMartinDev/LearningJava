package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletMultiplicar")
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
		
		String sNumero1 = request.getParameter("numero1");
		String sNumero2 = request.getParameter("numero2");
		if(sNumero1 != null) {
			int numero1 = Integer.parseInt(sNumero1);
			String tabla1 = crearTabla(numero1);
			mensaje += tabla1;
		}
		
		if(sNumero2 != null) {
			int numero2 = Integer.parseInt(sNumero2);
			String tabla2 = crearTabla(numero2);
			mensaje += tabla2;	
		}		
		
		response.getWriter().append(mensaje);
		response.setContentType("text/html");
	}

	private String crearTabla(int numero) {
		String mensaje = "<table>";
		for(int i=0;i<=10;i++) {
			mensaje += "<tr>";
			mensaje += "<td>" + numero + "</td>";
			mensaje += "<td> * " + i + "</td>";
			mensaje += "<td> = " + (numero * i) + "</td>";
			mensaje += "</tr>";
		}
		mensaje += "</table>";
		return mensaje;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
