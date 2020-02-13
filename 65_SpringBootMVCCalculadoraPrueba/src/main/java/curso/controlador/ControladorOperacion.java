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
	
	@Autowired
	public Operacion operacion;
	
	@RequestMapping("calculadora")
	public String alta() {
		return "formCalculadora";
	}
	
	@RequestMapping("doCalculadora")
	public ModelAndView doCalculadora(
			@RequestParam() Double numero1,
			@RequestParam() Double numero2,
			@RequestParam() String operator,
			ModelAndView mav) {
		
		operacion.setId(0);
		operacion.setNumero1(numero1);
		operacion.setNumero2(numero2);
		operacion.setOperador(operator);
		
		boolean operacionValida;
		operacionValida = go.Operar(operacion);
		
		if (!operacionValida) {
			System.out.println("La operacion no es válida");
		}
		
		mav.addObject("resultado", operacion.getResultado());
		mav.addObject("listaOperaciones", go.mostrarOperaciones());			
		mav.setViewName("formCalculadora");
		
		return mav;
	}
	
}

