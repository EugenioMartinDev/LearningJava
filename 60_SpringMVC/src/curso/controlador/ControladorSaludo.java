package curso.controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Persona;

//por este controla
@Controller
public class ControladorSaludo {

	//inyecta una persona si existe en el contexto de spring
	@Autowired
	private Persona persona;
	
	//mediante esta anotacion le estamos diciendo al
	//super servlet de spring que las peticiones con url
	//"saludo" entren por este metodo. Al no decirle el verbo
	//http, mapea todos los verbos http
	//OJO!!! hay que pasar por el super servlet por lo tanto
	//esta url realmente es : "/mvc/saludo"
	@RequestMapping("saludo")
	public String metodo1() {
		//este tipo de envio seria por forward
		//y consultaria con el viewResolver para saber
		//donde se encuentra esre recurso
		//la direccion del recurso resultante seria
		// /WEB-INF/vistas/inicioSaludo.jsp
		return "inicioSaludo";
	}
	
	//El objeto ModelAndView sirve para establecer la
	//la vista a la que vamos y tambien le podemos
	//establecer los atributos que queremos pasarle a la vista
	@RequestMapping("otroSaludo")
	public ModelAndView otroSaludo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inicioSaludo");
		return mav;
	}
	
	
	//Podemos hacer que una serie de objetos los inicialice
	//y me los inyecte Spring por mi, entre ellos
	//el objetos ModelAndView
	@RequestMapping("otroSaludoMas")
	public ModelAndView otroSaludo(ModelAndView mav) {
		mav.setViewName("inicioSaludo");
		return mav;
	}
	
	//Recoger parametros se hace de manera sencilla
	@RequestMapping("saludoParametros")
	public ModelAndView saludoParametros(ModelAndView mav, HttpServletRequest request) {
		String param1 = request.getParameter("nombre");
		System.out.println("El nombre es : " + param1);
		mav.setViewName("inicioSaludo");
		return mav;
	}
	
	//Recoger parametros se hace de manera sencilla
	@RequestMapping("saludoParametrosSencillo")
	public ModelAndView saludoParametros(ModelAndView mav, 
			@RequestParam("nombre")String param1,
			@RequestParam("edad") int param2) {
		System.out.println("El nombre es : " + param1);
		System.out.println("La edad es : " + param2);
		mav.setViewName("inicioSaludoParametros");
		return mav;
	}
	
	//Recoger parametros se hace de manera sencilla
		@RequestMapping("saludoAtributos")
		public ModelAndView saludoAtributos(ModelAndView mav, 
				@RequestParam("nombre")String param1,
				@RequestParam("edad") int param2) {
			System.out.println("El nombre es : " + param1);
			System.out.println("La edad es : " + param2);
			
			//una manera de crear una persona
			//Persona p = new Persona();
			
			//otra manera, por Spring y autowire
			persona.setNombre(param1);
			persona.setEdad(param2);
			
			mav.setViewName("inicioSaludoAtributos");
			mav.addObject("p", persona);
			return mav;
		}

		@RequestMapping("saludoRedirect")
		public String metodoRedirect() {
			//este tipo de envio seria por forward
			//y consultaria con el viewResolver para saber
			//donde se encuentra esre recurso
			//la direccion del recurso resultante seria
			// /WEB-INF/vistas/inicioSaludo.jsp
			return "redirect:inicioSaludo";
			//este return al ser un redirect le diremos
			//que vaya a buscar un controlador que sea
			// /mvc/inicioSaludo. No existe, con lo cual
			// tendremos que crearlo. Cuando hacemos un
			// redirect es muy importante enteder que no
			// pasamos por el viewResolver, estas mandando
			//un 300 al navegador para que vaya a esa
			//url
		}
		
		@RequestMapping("inicioSaludo")
		public String metodoInicioSaludo() {
			//Ahora si que va a pasar por el view3REsolver
			return "inicioSaludo";
		}
}
