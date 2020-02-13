package curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Operacion;
import curso.modelo.negocio.GestorOperacion;


@Controller
public class ControladorOperacion {

	@Autowired
	public GestorOperacion go;

	@RequestMapping("calculadora")
	public String alta() {
		return "formCalculadora";
	}
	
	@RequestMapping("doCalculadora")
	public ModelAndView doCalculadora(
			@RequestParam(required = false) Double numero1,
			@RequestParam(required = false) Double numero2,
			@RequestParam(required = false) String operator,
			@RequestParam(required = false) String listar, 
			ModelAndView mav) {
		
		if (listar == null) {
			if (numero1 == null
					||
					numero2 == null
					||
					operator == null) {
				System.out.println("Los operadores son nulos");
				mav.setViewName("redirect:calculadora");
				return mav;
			}
			
			
			Operacion operacion = new Operacion();
			operacion.setNumero1(numero1);
			operacion.setNumero2(numero2);
			operacion.setOperador(operator);
			
			boolean operacionValida;
			operacionValida = go.Operar(operacion);
			
			if (!operacionValida) {
				System.out.println("La operacion no es válida");
				mav.setViewName("redirect:calculadora");
				return mav;
			} else {
				System.out.println("Operación actualizada en la base de datos");
				mav.addObject("operacion", operacion);
			}
									
		} else {
			System.out.println("listar");
			mav.addObject("listaOperaciones", go.mostrarOperaciones());	
		}

		mav.setViewName("formCalculadora");
		
		return mav;
	}
	
}

