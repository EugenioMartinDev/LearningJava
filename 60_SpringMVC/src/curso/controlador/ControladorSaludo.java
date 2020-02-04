package curso.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Por este controla
@Controller
public class ControladorSaludo {

	//Mediante esta anotaci�n le estamos diciendo al 
	//super servlet de spring que las peticiones con url
	//"saludo" entren por este m�todo. Al no decirle el verbo
	//http, mapea todos los verbos http.
	//OJO!!! Hay que pasar por el super servlet, por lo tanto,
	//esta URL es "/mvc/saludo".
	@RequestMapping("saludo")
	public String metodo1() {
		
		//Este tipo de env�o es por FORWARD
		//y consultar�a con el viewResolver para conocer la 
		//direcci�n del recurso
		//La direcci�n resultante ser�a "/WEB-INF/vistas/inicioSaludo.jsp"
		return "inicioSaludo";
	}
	
}
