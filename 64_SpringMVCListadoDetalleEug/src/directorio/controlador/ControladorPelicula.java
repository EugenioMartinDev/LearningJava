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
	public ModelAndView mostrarAltaPelicula(
			@RequestParam() String nombre,
			ModelAndView mav) {
	
		mav.getModelMap().addAttribute("nombre", nombre);
		mav.setViewName("altaPelicula");
		
		return mav;
	}
	
	@RequestMapping("doAltaPelicula")
	public ModelAndView hacerAltaPelicula(
			@RequestParam() String titulo,
			@RequestParam() String year,
			@RequestParam() Double recaudacion,
			@RequestParam() String nombre,
			ModelAndView mav) {
		
		pelicula.setTitulo(titulo);
		pelicula.setYear(year);
		pelicula.setRecaudacion(recaudacion);
		//peliculaBase.setPelicula(pelicula);
	    //pelicula.setPeliculaBase(peliculaBase);
		
		String mensaje = gp.alta(pelicula);
		mav.getModelMap().addAttribute("mensaje", mensaje);	
		mav.getModelMap().addAttribute("nombre", nombre);	
		mav.setViewName("redirect:inicio");
		
		return mav;
		
	}
	

	@RequestMapping("listadoPeliculas")
	public ModelAndView listarPeliculas(
			@RequestParam() String nombre,
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
		mav.getModelMap().addAttribute("nombre", nombre);
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
			@RequestParam() String nombre,
			ModelAndView mav){
		
		int iIdentity = Integer.parseInt(identity);
		
		Peli pelicula = gp.getPelicula(iIdentity);
		
		System.out.println("Peli en controlador " + pelicula);

		mav.getModelMap().addAttribute("pelicula", pelicula);		
		mav.getModelMap().addAttribute("nombre", nombre);
		mav.setViewName("darDetalles");
		
		return mav;
		
	}

	
	@RequestMapping("volverListado")
	public ModelAndView volverListado(
			@RequestParam() String nombre,
			ModelAndView mav) {
		
		mav.getModelMap().addAttribute("nombre", nombre);
		mav.setViewName("redirect:listadoPeliculas");

		return mav;
	}
	
	@RequestMapping("volverUsuario")
	public String volverUsuario() {

		return "redirect:pepe";
	}
	
	@RequestMapping("volverAltaPelicula")
	public ModelAndView volverAltaPelicula(
			@RequestParam() String nombre,
			ModelAndView mav) {
		
		mav.getModelMap().addAttribute("nombre", nombre);
		mav.setViewName("redirect:altaPeliculas");

		return mav;
	}
}



