package directorio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.negocio.GestorPelicula;

@Controller
public class ControladorPelicula {

	@Autowired
	GestorPelicula gp;
	
	@Autowired
	Pelicula pelicula;
		
	
	@RequestMapping("altaPeliculas")
	public String mostrarAltaPelicula() {
		return "altaPelicula";
	}
	
	@RequestMapping("doAltaPelicula")
	public ModelAndView hacerAltaPelicula(
			@RequestParam() String titulo,
			@RequestParam() String year,
			@RequestParam() Double recaudacion,
			ModelAndView mav) {
		
		pelicula.setTitulo(titulo);
		pelicula.setYear(year);
		pelicula.setRecaudacion(recaudacion);
		
		String error = gp.alta(pelicula);
		if (error.isEmpty()) {
			mav.getModelMap().addAttribute("mensaje","La pelicula se ha incluido en el directorio");
		} else {
			mav.getModelMap().addAttribute("mensaje",error);
		}
		
		mav.setViewName("redirect:inicio");
		return mav;
		
	}
	
	
}



