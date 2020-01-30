package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Pc;
import modelo.entidad.Pedido;
import modelo.negocio.GestorPcs;

/**
 * Servlet implementation class PcForm
 */
@WebServlet("/PcForm")
public class PcForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PcForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por doGet");
		System.out.println(request.toString());
		String modelo = request.getParameter("modelo");
		String procesador = request.getParameter("procesador");
		String memoria = request.getParameter("memoria");
		String devices[] = request.getParameterValues("devices");
		String comentario = request.getParameter("comentarios");
		
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		
		Pc pc = new Pc();
		pc.setModelo(modelo);
		pc.setProcesador(procesador);
		pc.setMemoria(memoria);
		pc.setDevices(devices);

		Pedido pedido = new Pedido();
		pedido.setNombre(nombre);
		pedido.setDireccion(direccion);
		pedido.setEmail(email);
		pedido.setPc(pc);
		pedido.setComentario(comentario);
		
		GestorPcs gp = new GestorPcs();
		boolean validada = gp.Validar(pedido.getPc());
		
		if (validada) {
			
			System.out.println(pc);
		
			//Debemos introducir en la request los valores creados en doGet para que los conozca final.jsp
			/*
			request.setAttribute("nombre", pedido.getNombre());
			request.setAttribute("direccion", pedido.getDireccion());
			request.setAttribute("email", pedido.getEmail());
			request.setAttribute("modelo", pedido.getPc().getModelo());
			request.setAttribute("procesador", gp.Xlate_Procesador(Integer.parseInt(pedido.getPc().getProcesador())));
			request.setAttribute("memoria", gp.Xlate_Memoria(Integer.parseInt(pedido.getPc().getMemoria())));
			request.setAttribute("dispositivos", pedido.getPc().getDevices());
			request.setAttribute("comentarios", pedido.getComentario());
			*/
			request.setAttribute("pedido", pedido);
			request.setAttribute("listaDispositivos", Arrays.asList(pedido.getPc().getDevices()));
			request.setAttribute("procesador", gp.Xlate_Procesador(Integer.parseInt(pedido.getPc().getProcesador())));
			request.setAttribute("memoria", gp.Xlate_Memoria(Integer.parseInt(pedido.getPc().getMemoria())));
	
			//Le decimos a JVM que siga la ejecución de esta request en "final.jsp" - cambio de contexto
			request.getRequestDispatcher("final.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("index.html");
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());  // getWriter rellana el body -en condiciones normalels esto es un 200OK
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por doPost");
		System.out.println(request.toString());
		doGet(request, response);
		
		
	}

}
