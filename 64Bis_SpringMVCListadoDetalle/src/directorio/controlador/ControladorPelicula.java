package directorio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.entidad.PeliculaBase;
import directorio.modelo.negocio.GestorPelicula;

@Controller
public class ControladorPelicula {

	@Autowired
	GestorPelicula gp;
	
	@Autowired
	Pelicula pelicula;
	
	@Autowired
	PeliculaBase peliculaBase;
	
	@Autowired
	List<Pelicula> listaPeliculas;
		
	
	@RequestMapping("altaPeliculas")
	public String mostrarAltaPelicula(
			@RequestParam() String usuario) {
		return "altaPelicula?usuario";
	}
	
	@RequestMapping("doAltaPelicula")
	public ModelAndView hacerAltaPelicula(
			@RequestParam() String titulo,
			@RequestParam() String year,
			@RequestParam() Double recaudacion,
			@RequestParam() String usuario,
			ModelAndView mav) {
		
		peliculaBase.setTitulo(titulo);
		pelicula.setYear(year);
		pelicula.setRecaudacion(recaudacion);
		peliculaBase.setPelicula(pelicula);
		
		String mensaje = gp.alta(peliculaBase);
		mav.addObject("nombre", usuario);
		mav.getModelMap().addAttribute("mensaje", mensaje);		
		mav.setViewName("redirect:inicio");
		
		return mav;
		
	}
	

	@RequestMapping("listadoPeliculas")
	public ModelAndView listarPeliculas(
			ModelAndView mav,
			@RequestParam() String usuario){
		
		//String mensaje = gp.listar();
		String mensaje = "";

		mav.getModelMap().addAttribute("mensaje", mensaje);
		mav.addObject("listaPeliculas", listaPeliculas);
		mav.addObject("nombre", usuario);
		mav.setViewName("listarDetalles");
		
		return mav;
		
	}
	
}



