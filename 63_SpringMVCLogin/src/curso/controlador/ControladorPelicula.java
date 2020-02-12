package curso.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Pelicula;
import curso.modelo.negocio.GestorPelicula;

@Controller
public class ControladorPelicula {

	@Autowired
	public GestorPelicula gp;
	
	@RequestMapping("peliculas/alta")
	public String alta() {		
		return "peliculas/alta";
	}
	
	@RequestMapping("peliculas/doAltaPelicula")
	public ModelAndView doAltaPelicula(
			@RequestParam() String titulo,
			@RequestParam() String director,
			@RequestParam() String genero,
			@RequestParam() int year,
			ModelAndView mav) {
		
		Pelicula p = new Pelicula();
		p.setTitulo(titulo);
		p.setDirector(director);
		p.setGenero(genero);
		p.setYear(year);
		
		gp.alta(p);
		
		//Como estamos accediendo a la url http://localhost:8080/Nomre_Proyecto/peliculas/doAltaPelicula
		//y vamos a ir a alta de forma relativa, no es necesario indicar otra vez el path peliculas/
		mav.setViewName("redirect:alta");
		mav.getModelMap().addAttribute("mensaje", "La pelicula se ha insertado con el id " + p.getId());
		
		return mav;
	}
	
	@RequestMapping("peliculas/listar")
	public ModelAndView listar(
			@RequestParam(required=false) Integer idPelicula,
			ModelAndView mav) {
		
		List<Pelicula> listaPeliculas = gp.listar();
		if (idPelicula != null) {
			Pelicula p = gp.getPeliculaById(idPelicula);
			mav.addObject("pelicula", p);
		}
		
		
		mav.addObject("listaPeliculas", listaPeliculas);

		mav.setViewName("peliculas/listar");
		
		return mav;

	}
	
	
	@RequestMapping("peliculas/detalle")
	public ModelAndView detalle(
			@RequestParam() int id,
			ModelAndView mav) {	
		
		Pelicula p = gp.getPeliculaById(id);
		
		mav.addObject("pelicula", p);
		mav.setViewName("peliculas/detalle");
		
		return mav;
	}
	
}
