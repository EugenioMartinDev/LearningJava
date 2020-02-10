package directorio.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.entidad.PeliculaBase;
import directorio.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	DaoPelicula dp;
	
	@Autowired
	List<PeliculaBase> listaTituloPelicula;

	public String alta(PeliculaBase peliculaBase) {
		
		if (peliculaBase.getTitulo().isEmpty() 
				||
			peliculaBase.getPelicula().getYear().isEmpty()
				||
			peliculaBase.getPelicula().getRecaudacion() == null)
		{
			return "Todos los campos tienen que incluir informacion";
		}
		
		dp.save(peliculaBase);
		return "La pelicula ha sido insertada en el directorio";

	}

	/*
	public String listar() {
		
		listaTituloPelicula = dp.selectIdAndTitulo();
		
		if (listaTituloPelicula == null
				||
			listaTituloPelicula.isEmpty())
		{
			return "No existe ninguna pelicula en el directorio";
		}
		
		return "";
	}
	*/

	
}
