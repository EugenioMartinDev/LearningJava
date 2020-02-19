package curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Producto;
import curso.modelo.negocio.GestorProducto;

@Controller
public class ControladorProducto {

	@Autowired
	private GestorProducto gp;
	
	@RequestMapping("supermercado")
	public ModelAndView inicio(ModelAndView mav) {
		List<Producto> lista = gp.getLista();

		mav.addObject("lista", lista);
		mav.setViewName("supermercado");
		return mav;
	}
	
	@RequestMapping("alta")
	public ModelAndView alta(
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) String categoria,
			ModelAndView mav) {
		
		mav.setViewName("redirect:supermercado");
		//esto lo suyo es en el gestor, pero podemos
		//validar los datos
		boolean hayError = false;
		if(nombre == null || nombre.isEmpty()) {
			mav.getModelMap().addAttribute("errorNombre", "Falta el nombre");
			hayError = true;
		}
		
		if(precio == null) {
			mav.getModelMap().addAttribute("errorPrecio", "Falta el precio");
			hayError = true;
		}
		
		if(categoria == null || categoria.isEmpty()) {
			mav.getModelMap().addAttribute("errorCategoria", "Falta la categoria");
			hayError = true;
		}
		
		if(hayError) {
			/*
			 * Esto es para volver a pintar los valores que son correctos en
			 * la pagina web supermercado
			 * Este atributo es el que recogeremos en el atributo html "value"
			 */
			if (nombre != null && !nombre.isEmpty()) {
				mav.getModelMap().addAttribute("nombre", nombre);
			}
			if (precio != null) {
				mav.getModelMap().addAttribute("precio", precio);
			}
			if (categoria != null && !categoria.isEmpty()) {
				mav.getModelMap().addAttribute("categoriaRcvd", categoria);
			}
			return mav;
		}
		
		//si no hay errores hago lo que tenga que hacer
		Producto pro = new Producto();
		pro.setId(0);
		pro.setNombre(nombre);
		pro.setPrecio(precio);
		pro.setCategoria(categoria);
		
		gp.alta(pro);
		System.out.println(pro);
		mav.getModelMap().addAttribute("mensaje", "Producto dado de alta. Id: " + pro.getId());
		return mav;
	}
}
