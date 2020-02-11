package directorio.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.negocio.GestorPelicula;

@Controller
public class ControladorPelicula {

	@Autowired
	GestorPelicula gp;
	
	@Autowired
	Pelicula pelicula;

	@Autowired
	List<Pelicula> listaPeliculas;
		
	
	@RequestMapping("altaPeliculas")
	public String mostrarAltaPelicula(
			@RequestParam() String nombre) {
		return "altaPelicula";
	}
	
	@RequestMapping("doAltaPelicula")
	public ModelAndView hacerAltaPelicula(
			@RequestParam() String titulo,
			@RequestParam() String year,
			@RequestParam() Double recaudacion,
			ModelAndView mav) {
		
		pelicula.setId(0);
		pelicula.setTitulo(titulo);
		pelicula.setYear(year);
		pelicula.setRecaudacion(recaudacion);
		
		String mensaje = gp.alta(pelicula);
		mav.addObject("mensaje", mensaje);		
		mav.setViewName("redirect:inicio");
		
		return mav;
		
	}
	

	@RequestMapping("listadoPeliculas")
	public ModelAndView listarPeliculas(
			ModelAndView mav,
			@RequestParam() String nombre){
		
		//String mensaje = gp.listar();
		String mensaje = "";
		List<Object[]> listaIdTitulos = gp.listar();
		ArrayList<String[]> listaStringIdTitulos = new ArrayList<String[]>();
		for (Object[] element : listaIdTitulos)
		{
			String id = String.valueOf((int) element[0]);
			String titulo = (String) element[1];
			String[] elementString = new String[2];
			elementString[0] = id;
			System.out.println("id " +id);
			elementString[1] = titulo;	
			System.out.println("titulo " + titulo);
			listaStringIdTitulos.add(elementString);			
		}
		
		if (listaIdTitulos == null
				||
				listaIdTitulos.isEmpty())
		{
			mensaje = "No existe ninguna pelicula en el directorio";
		}
		
		mav.getModelMap().addAttribute("mensaje", mensaje);
		mav.getModelMap().addAttribute("listaPeliculas", listaIdTitulos);
		mav.setViewName("listarDetalles");
		
		return mav;
		
	}
	
	
	@RequestMapping("detalle")
	public ModelAndView mostrarDetalles(
			@RequestParam() String id,
			ModelAndView mav) {
		
		int iId = Integer.parseInt(id);
		Pelicula pelicula = gp.getPelicula(iId);
		
		mav.getModelMap().addAttribute("pelicula", pelicula);
		mav.setViewName("showDetalles");
		
		return mav;
		
	}
	
}



