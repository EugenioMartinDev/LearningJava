package curso.controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Persona;

//Por este controla
@Controller
public class ControladorSaludo {

	//Otra manera de crear una persona (Ver saludosAtributos método)
	@Autowired
	private Persona persona;
	
	
	//Mediante esta anotación le estamos diciendo al 
	//super servlet de spring que las peticiones con url
	//"saludo" entren por este método. Al no decirle el verbo
	//http, mapea todos los verbos http.
	//OJO!!! Hay que pasar por el super servlet, por lo tanto,
	//esta URL es "/mvc/saludo".
	@RequestMapping("saludo")
	public String metodo1() {
		
		//Este tipo de envío es por FORWARD
		//y consultaría con el viewResolver para conocer la 
		//dirección del recurso
		//La dirección resultante sería "/WEB-INF/vistas/inicioSaludo.jsp"
		return "inicioSaludo";
	}
	
	//El objeto ModelAndView sirve para establece la vista a la que vamos
	//y también le podemos establecer los atributos que queremos pasarle a la vista
	@RequestMapping("otroSaludo")
	public ModelAndView otroSaludo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inicioSaludo");
		return mav;
	}
	
	//Podemos hacer que una serie de objetos los inicialise y los inyecte
	//por mi, entre ellos el objeto ModelAndView
	@RequestMapping("otroSaludoMas")
	public ModelAndView otroSaludoMas(ModelAndView mav) {
		mav.setViewName("inicioSaludo");
		return mav;
	}
	
	//Recoger los parámetros se hace de manera más sencilla
	@RequestMapping("saludoParametros")
	public ModelAndView saludoParametros(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("inicioSaludo");
		String param1 = request.getParameter("nombre");
		System.out.println("El nombre es : " + param1);
		return mav;
	}
	
	@RequestMapping("saludoParametrosSencillo")
	public ModelAndView saludoParametrosSencillo(ModelAndView mav, @RequestParam("nombre")String param1) {
		mav.setViewName("inicioSaludo");
		System.out.println("El nombre es : " + param1);
		return mav;
	}
	
	@RequestMapping("saludoParametrosSencillo2")
	public ModelAndView saludoParametrosSencillo(ModelAndView mav, @RequestParam("nombre")String param1,
			@RequestParam("edad") int param2) {
		mav.setViewName("inicioSaludoParametros");
		System.out.println("El nombre es : " + param1 + " y la edad es " + param2);
		return mav;
	}
	
	
	@RequestMapping("saludoAtributos")
	public ModelAndView saludoAtributos(ModelAndView mav, @RequestParam("nombre")String param1,
			@RequestParam("edad") int param2) {
		mav.setViewName("inicioSaludoAtributos");
		System.out.println("El nombre es : " + param1 + " y la edad es " + param2);
		
		//Una manera de crear una persona
		//Persona persona = new Persona();
		
		//Otra manera por Spring (ver Autowired arriba)
		persona.setNombre(param1);
		persona.setEdad(param2);
		
		mav.addObject("p", persona);
		
		return mav;
	}

	
	//Falla la redirección porque inicioSaludo está escondido en WEB-INF pero el cliente va a intentar acceder a él, lo que está prohibido.
	//Habría que llamar a una entrada del controlador que llame a inicioSaludo, o crear una nueva entrada con ese nombre.
	@RequestMapping("saludoRedirect")
	public String metodoRedirect() {
		return "redirect:inicioSaludo";
	}
	
	//Nueva entrada para el ViewResolver
	@RequestMapping("inicioSaludo")
	public String inicioSaludo() {
		return "inicioSaludo";
	}
	
}
