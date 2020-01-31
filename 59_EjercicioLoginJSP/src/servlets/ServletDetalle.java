package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Detalle;
import modelo.entidad.Login;
import modelo.negocio.GestorLogin;

@WebServlet("/ServletDetalle")
public class ServletDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, Detalle> datosDetalle;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		initDatosDetalle();
		
		String usuario = request.getParameter("usuario");
		
		
		if(datosDetalle.get(usuario) != null) {
			Detalle detalle = datosDetalle.get(usuario);
			System.out.println("detalle encontrado: " + detalle);
			request.setAttribute("detalle", detalle);
			request.getRequestDispatcher("detalle.jsp").forward(request, response);
		}else {
			System.out.println("No existe detalle del usuario : " + usuario);
			response.sendRedirect("bienvenida.jsp?error=No existe detalle del usuario");
		}
		
	}

	public static void initDatosDetalle() {
		
		datosDetalle = new HashMap<String, Detalle>();
		
		Detalle detalle = new Detalle();
		detalle.setNombre("Jose");
		detalle.setDireccion("Madrid");
		detalle.setEdad(38);
		detalle.setPeso(85);
		datosDetalle.put(detalle.getNombre(), detalle);
		
		Detalle detalle1 = new Detalle();
		detalle1.setNombre("Juan");
		detalle1.setDireccion("Cáceres");
		detalle1.setEdad(47);
		detalle1.setPeso(98);
		datosDetalle.put(detalle1.getNombre(), detalle1);
		
		Detalle detalle2 = new Detalle();
		detalle2.setNombre("Pablo");
		detalle2.setDireccion("Bilbao");
		detalle2.setEdad(23);
		detalle2.setPeso(72);
		datosDetalle.put(detalle2.getNombre(), detalle2);
		
	}
	
	

}
