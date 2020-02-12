package directorio.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import directorio.modelo.entidad.Peli;
import directorio.modelo.entidad.Pelicula;
import directorio.modelo.entidad.PeliculaBase;
import directorio.modelo.entidad.ShowPelicula;
import directorio.modelo.negocio.GestorPelicula;

@Controller
public class ControladorPelicula {

	@Autowired
	GestorPelicula gp;
	
	@Autowired
	Peli pelicula;
	
	//@Autowired
	//PeliculaBase peliculaBase;
		
	
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
		//peliculaBase.setPelicula(pelicula);
	    //pelicula.setPeliculaBase(peliculaBase);
		
		String mensaje = gp.alta(pelicula);
		mav.getModelMap().addAttribute("mensaje", mensaje);		
		mav.setViewName("redirect:inicio");
		
		return mav;
		
	}
	

	@RequestMapping("listadoPeliculas")
	public ModelAndView listarPeliculas(
			ModelAndView mav){
		
		//List<PeliculaBase> listaPeliculasBase = gp.listar();
		List<Peli> listaPeliculasBase = gp.getListaIdTitulo();
		
		/*
		if (listaPeliculasBase != null) {
			System.out.println("listado");
			for (PeliculaBase pb : listaPeliculasBase) {
				System.out.println("Pelicula " + pb.getId());
			}			
		} else {System.out.println("No hay listado");}
		*/
		
		String mensaje = "Listado";
		
		if (listaPeliculasBase == null
			||
			listaPeliculasBase.isEmpty())
		{
			mensaje = "No existe ninguna pelicula en el directorio";
		}

		mav.getModelMap().addAttribute("mensaje", mensaje);
		mav.addObject("listaPeliculasBase", listaPeliculasBase);
		/*
		ArrayList<Integer> idList = new ArrayList<Integer>();
		ArrayList<String> tituloList = new ArrayList<String>();
		ArrayList<ShowPelicula> showPeliculaList = new ArrayList<ShowPelicula>();
		for (PeliculaBase pb : listaPeliculasBase) {
			int id = pb.getId();
			String titulo = pb.getTitulo();
			ShowPelicula showPelicula = new ShowPelicula();
			showPelicula.setId(id);
			idList.add(id);
			tituloList.add(titulo);
			showPelicula.setTitulo(titulo);
			showPeliculaList.add(showPelicula);
		}
		mav.getModelMap().addAttribute("listaIds", idList);
		mav.getModelMap().addAttribute("listaTitulos", tituloList);
		mav.getModelMap().addAttribute("listaPeliculas", listaPeliculasBase);
		*/
		//mav.addObject("mensaje", mensaje);
		//mav.addObject("listaPeliculasBase", listaPeliculasBase);
		mav.setViewName("listarDetalles");
		
		return mav;
		
	}

	
	@RequestMapping("detalle")
	public ModelAndView listarPeliculasDetalle(
			@RequestParam() String identity,
			ModelAndView mav){
		
		int iIdentity = Integer.parseInt(identity);
		
		Peli pelicula = gp.getPelicula(iIdentity);		

		mav.getModelMap().addAttribute("titulo", pelicula.getTitulo());
		mav.getModelMap().addAttribute("year", pelicula.getYear());
		mav.getModelMap().addAttribute("recaudacion", pelicula.getRecaudacion());
		mav.setViewName("redirect:showDetalles");
		
		return mav;
		
	}
	
	@RequestMapping("showDetalles")
	public String mostrarDetalles() {
		return "darDetalles";
	}
	
	
	@RequestMapping("volverListado")
	public String volverListado() {

		return "redirect:listadoPeliculas";
	}
	
	@RequestMapping("volverUsuario")
	public String volverUsuario() {

		return "redirect:pepe";
	}
	
	@RequestMapping("volverAltaPelicula")
	public String volverAltaPelicula() {

		return "redirect:altaPeliculas";
	}
}



