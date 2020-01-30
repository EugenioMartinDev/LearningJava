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
			response.sendRedirect("inicio.html");
		}else {
			System.out.println("Pedido NO validado: " + pedido);
			response.sendRedirect("formulario.html");
		}
	}

}
