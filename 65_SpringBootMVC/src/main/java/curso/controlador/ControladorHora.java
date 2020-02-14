package curso.controlador;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHora {

	@RequestMapping("saludoHora")
	public ModelAndView hora(ModelAndView mav) {
		Date date  = new Date();//me da la fecha del sistema
		mav.addObject("fecha", date);
		mav.setViewName("mostrarHora");
		return mav;
	}
	
}
