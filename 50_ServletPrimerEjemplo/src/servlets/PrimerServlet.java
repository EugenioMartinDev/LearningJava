package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 * Un servlet es un objeto singleton gestionado por
 * el contexto de Tomcat
 * 
 * Tenemos que extender la clase de HttpServlet
 * 
 * Por otro lado tenemos que decir a Tomcat que dé de alta
 * este objeto. Concepto de IoC. Nosotros no creamos el 
 * objeto, es decir, no hacemos new de PrimerServlet, si no que
 * TomCat llevará el ciclo de vida por nostros. "no nos llame usted,
 * ya le llamaremos nosotros - Patro Hollywood"
 * 
 * Dos maneras de dar de alta un objeto en el contexto de TomCat:
 * - Por XML (web.xml)
 * - Por anotaciones
 * 
 * Como hemos elegido crear el proyecto con descriptor web.xml 2.5,
 * solo podemos hacerlo por xml. Desde Spring 3, ya se puede hacer por 
 * anotaciones.
 * 
 * Por lo tanto, debemos dar de alta este objeto por XML. Eclipse lo
 * hace automáticamente cada vez que se hace un new de Servlet.
 */
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<h1>Hola caracola</h1>" + new Date());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
