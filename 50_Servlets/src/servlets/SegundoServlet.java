package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Direccion Remota " + request.getRemoteAddr());
		
		if(request.getRemoteAddr().equals("192.168.1.91")){
			response.getWriter().append(""
					+ "<html>"
					+ "<body>"
					+ "<title>segunda pagina</title>"
					+ "<h1 style='color:red'>Estas baneado!!</h1>"
					+ "</body>"
					+ "</html>");
		}else {
		
			response.getWriter().append(""
					+ "<html>"
					+ "<body>"
					+ "<title>segunda pagina</title>"
					+ "<h1 style='color:red'>Hola segundo servlet</h1>"
					+ "</body>"
					+ "</html>");
		}
		response.setContentType("text/html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
