package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Ordenador;
import modelo.entidad.Pedido;
import modelo.negocio.GestorPedido;

@WebServlet("/ServletFormulario")
public class ServletFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger los parametros
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		String ram = request.getParameter("ram");
		String procesador = request.getParameter("procesador");
		String[] perifericos = request.getParameterValues("opciones");
		String comentarios = request.getParameter("comentarios");
		
		//Segundo, formar el objeto que vamos a usar
		Ordenador ordenador = new Ordenador();
		ordenador.setRam(ram);
		ordenador.setProcesador(procesador);
		ordenador.setArrayPerifericos(perifericos);
		
		//para la lista, debemos de convertir el array en una lista
		//opcion 1
		List<String> listaPerifericos = new ArrayList<String>();
		if(perifericos != null) {
			for(String periferico : perifericos) {
				listaPerifericos.add(periferico);
			}
			
			ordenador.setListaPerifericos(listaPerifericos);
			//opcion 2, que alguien lo haga por mi
			listaPerifericos = Arrays.asList(perifericos);
			ordenador.setListaPerifericos(listaPerifericos);
		}
		
		
		//Ahora creamos el pedido
		Pedido pedido = new Pedido();
		pedido.setNombreCliente(nombre);
		pedido.setDireccion(direccion);
		pedido.setEmail(email);
		pedido.setOrdenador(ordenador);
		pedido.setComentario(comentarios);
		
		
		GestorPedido gp = new GestorPedido();
		boolean validado = gp.validar(pedido);
		
		if(validado) {
			System.out.println("Pedido validado: " + pedido);
			request.setAttribute("pedido", pedido);
			request.getRequestDispatcher("final.jsp").forward(request, response);
		}else {
			System.out.println("Pedido NO validado: " + pedido);
			//Esto puede ser una menera, el problema es que no cambia
			//la url a "formulario.jsp", entonces si ser recarga
			//la pagina se volveria a mandar le formulario
			//request.setAttribute("error", "No ha relleando adecuadamente el formulario");
			//request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
			//Siempre que se envie un formulario se deberia hacer
			//un redirect en vez de un forward
			response.sendRedirect("formulario.jsp?error=No ha rellenado adecuadametne el formulario");
		}
	}

}
