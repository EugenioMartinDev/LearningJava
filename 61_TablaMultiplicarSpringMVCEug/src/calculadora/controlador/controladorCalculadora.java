package calculadora.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controladorCalculadora {
	
	@RequestMapping("multiplicar")
	public String multiplicar() {
		return "multiplicacion";
	}
	
}
