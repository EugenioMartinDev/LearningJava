package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletParametros")
public class ServletParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//los parametros vienen siempre en la request
		//y SIEMPRE en formato cadena
		String param1 = request.getParameter("parametro1");
		String param2 = request.getParameter("parametro2");
		System.out.println(param1);
		System.out.println(param2);
		
		response.getWriter().append("Has escrito: ").append(param1).append(", ").append(param2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
