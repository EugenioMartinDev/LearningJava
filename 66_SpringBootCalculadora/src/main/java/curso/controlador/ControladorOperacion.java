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
	private GestorOperacion go;
	
	@RequestMapping("calculadora")
	public ModelAndView inicio(ModelAndView mav) {
		List<Operacion> lista = go.getLista();
		
		mav.addObject("lista", lista);
		mav.setViewName("calculadora");
		return mav;
	}
	
	@RequestMapping("alta")
	public ModelAndView alta(
			@RequestParam() Double numero1,
			@RequestParam() Double numero2,
			@RequestParam(required = false) String tipo,
			ModelAndView mav) {
		
		mav.setViewName("redirect:calculadora");
		//esto lo suyo es en el gestor, pero podemos
		//validar los datos
		boolean hayError = false;
		if(numero1 == null) {
			mav.getModelMap().addAttribute("errorNumero1", "Falta el numero1");
			hayError = true;
		}
		
		if(numero2 == null) {
			mav.getModelMap().addAttribute("errorNumero2", "Falta el numero2");
			hayError = true;
		}
		
		if(tipo == null) {
			mav.getModelMap().addAttribute("errorTipo", "Falta el tipo de operacion");
			hayError = true;
		}
		
		if(hayError) {
			return mav;
		}
		
		//si no hay errores hago lo que tenga que hacer
		Operacion op = new Operacion();
		op.setNumero1(numero1);
		op.setNumero2(numero2);
		op.setTipo(tipo);
		
		go.calcular(op);
		System.out.println(op.getResultado());
		mav.getModelMap().addAttribute("mensaje", "Operacion dada de alta. Id: " + op.getId());
		mav.getModelMap().addAttribute("resultado", op.getResultado());
		return mav;
	}
}
