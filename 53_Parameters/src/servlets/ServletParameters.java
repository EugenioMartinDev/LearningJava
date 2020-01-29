package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletParametros
 */
@WebServlet("/ServletParameters")
public class ServletParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletParameters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Los parámetros vienen siempre en la request en formato cadena. En caso GET en la propia url. En POST en el body.
		String param1 = request.getParameter("parametro1"); //obtiene el valor de parametro1 de http://www.google.com/hola?parametro1:valor1&parametro2:valor2
		String param2 = request.getParameter("parametro2"); //obtiene el valor de parametro1 de http://www.google.com/hola?parametro1:valor1&parametro2:valor2

		System.out.println(param1);  //param1 contiene el valor del parametro1
		System.out.println(param2);  //param2 contiene el valor del parametro2
		
		String mensaje = "";
		mensaje += "<html>";
		mensaje += "<head>";
		mensaje += "<title>Tabla Multiplicar</title>";
		mensaje += "<body>";
		mensaje += "<h1>Tabla de multiplicar</h1>";
		mensaje += "<table>";
		int numero = 0;
		try {
			numero = Integer.parseInt(param1);
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
		} catch(Exception ex) {
			mensaje = ex.toString();
		}

		
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
