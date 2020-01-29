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
		String comentarios = request.getParameter("comentarios");
		
		List<String> list = Arrays.asList(devices);
		
		Pc pc = new Pc();
		pc.setModelo(modelo);
		pc.setProcesador(procesador);
		pc.setMemoria(memoria);
		pc.setDevices(devices);
		pc.setComentarios(comentarios);

		
		GestorPcs gp = new GestorPcs();
		boolean validada = gp.Validar(pc);
		
		if (validada) {
			
			System.out.println(pc);
			
			// sendRedirect implementa un código 300 al navegador
	 		String mensaje = "";
			mensaje += "<html>";
			mensaje += "<head>";
			mensaje += "<title>Formulario PC</title>";
			mensaje += "</head>";
			mensaje += "<body>";
			mensaje += "<h1>Datos introducidos en el formulario PC</h1>";
			mensaje += "<p1>MODELO : " + pc.getModelo() + "</p>";
			mensaje += "<p1>PROCESADOR : " + gp.Xlate_Procesador(Integer.parseInt(pc.getProcesador())) + "</p>";
			mensaje += "<p1>MEMORIA : " + gp.Xlate_Memoria(Integer.parseInt(pc.getMemoria())) + "</p>";
			mensaje += "<p1>DISPOSITIVOS : ";
			int indice = 1;
			for (String device : list) {
				mensaje += device;
				if (indice < list.size()) {
					mensaje += " - ";
				}
				indice++;
			}
			/*
			for (int i=0; i<pc.getDevices().length; i++) {
				mensaje += (i+1) + " - " + pc.getDevices()[i] + " ; ";
			}	
			*/	
			mensaje += "</p>";
			mensaje += "<p1>COMENTARIOS : " + pc.getComentarios() + "</p>";			
			response.getWriter().append(mensaje);
			response.setContentType("text/html");
			
			//response.sendRedirect("principal.html");
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
