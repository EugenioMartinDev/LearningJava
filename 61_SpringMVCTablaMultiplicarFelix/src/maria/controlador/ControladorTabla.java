package maria.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import maria.modelo.entidad.TablaMultiplicar;
import maria.modelo.negocio.GestorTabla;

//Objeto Controller en el contexto de Spring con la id=ControladorTabla
@Controller
public class ControladorTabla {

	@Autowired
	private GestorTabla gt;
	
	@Autowired
	private TablaMultiplicar tabla;
	
	@RequestMapping("calcularTablaMultiplicar")
	public ModelAndView mostrarTablaMultiplicar(
			@RequestParam("numero") int numero,
			ModelAndView mav) {
		System.out.println("Vamos a mostrar la table de multiplicar" 
			+ "del " + numero);
		
		tabla.setNumero(numero);
		gt.calcularTabla();
		
		mav.setViewName("mostrarTabla");
		mav.addObject("tablaMultiplicar", tabla);
		
		return mav;
		
		
		//return "mostrarTabla";
		
	}
	
}
