package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 * Un Servlet es un objeto singleton gestionado por 
 * el contexto de Tomcat
 * 
 * Tenemos que extender la clase de HttpServlet
 * 
 * Por otro lado tenemos que decirle a tomcat que de de alta este
 * objeto. Concepto de IoC, nosotros no creamos este objeto
 * es decir, no hacemos new de PrimerServlet, si no que tomcat
 * llevara el ciclo de vida por nosotros. "no nos llame usted,
 * ya le llamaremos nosotros"
 * Dos maneras de dar de alta un objeto en el contexto de Tomcat
 * por XML (web.xml) o por anotaciones
 * 
 * Como hemos elegido crear el proyecto con descritor web.xml
 * 2.5, solo podemos hacerlo por xml
 */
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>Hola caracola</h1> " + new Date());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
