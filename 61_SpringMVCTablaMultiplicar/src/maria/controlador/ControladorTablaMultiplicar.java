package maria.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import maria.modelo.entidad.TablaMultiplicar;
import maria.modelo.negocio.GestorTablaMultiplicar;

@Controller
public class ControladorTablaMultiplicar {
	
	@Autowired
	private GestorTablaMultiplicar gtm;
	
	@Autowired
	private TablaMultiplicar tm;
		
	@RequestMapping("calcularTablaMultiplicar")
	public ModelAndView mostrarTablaMultiplicar(
			@RequestParam("numero")int numero,
			ModelAndView mav) {
		System.out.println("Vamos a mostrar la tabla de multiplicar"
				+ " del " + numero);
		tm.setNumero(numero);
		
		gtm.calcularTablaMultiplicar();
		
		mav.setViewName("mostrarTabla");
		mav.addObject("tablaMultiplicar", tm);
		return mav;//vamos a un /vistilla/mostrarTabla.jsp	
	}
}
