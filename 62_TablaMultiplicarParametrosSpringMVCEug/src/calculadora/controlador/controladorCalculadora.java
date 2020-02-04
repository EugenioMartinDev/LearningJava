package calculadora.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;

import calculadora.modelo.entidad.Tabla;

@Controller
public class controladorCalculadora {
	
	@Autowired
	Tabla tabla1;
	@Autowired
	Tabla tabla2;
	
	@RequestMapping("tablaParametros")
	public ModelAndView tablaParametros(ModelAndView mav, @RequestParam("numero1") int param1,
		@RequestParam("numero2") int param2) {

		mav.setViewName("pintaTablas");
		System.out.println("El nombre es : " + param1 + " y la edad es " + param2);
		
		//Una manera de crear una persona
		//Persona persona = new Persona();
		
		//Otra manera por Spring (ver Autowired arriba)
		tabla1.setNumero(param1);
		tabla1.setTablaMultiplicar(crearTabla(tabla1.getNumero()));

		tabla2.setNumero(param2);
		tabla2.setTablaMultiplicar(crearTabla(tabla2.getNumero()));
		
		mav.addObject("tabla1", tabla1);
		mav.addObject("tabla2", tabla2);
					
		System.out.println("El numero 1 es : " + param1 + " y el numero 2 es : " + param2);
		
		System.out.println(tabla1);
		System.out.println(tabla2);
		
		return mav;
	}

	private List<Integer> crearTabla(int numero) {
		
		List<Integer> tablaMultiplicar = new ArrayList<Integer>();
	
		for(int i=1;i<=10;i++) {
			tablaMultiplicar.add(numero*i);
		}
		
		return tablaMultiplicar;
	}
	
}
