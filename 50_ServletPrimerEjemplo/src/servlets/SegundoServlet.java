package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html>" 
				+ "<body>"
				+ "<title>Segunda Pagina</title> "
				+ "<h1 style='color:red'>Hola segundo servlet</h1>"
				+ "</body>"
				+ "</html>");
		
		System.out.println("Local Address" + request.getLocalAddr());
		
		response.setContentType("text/html");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
