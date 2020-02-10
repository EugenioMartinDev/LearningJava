package directorio.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	DaoPelicula dp;

	public String alta(Pelicula pelicula) {
		
		if (pelicula.getTitulo().isEmpty() 
				||
			pelicula.getYear().isEmpty()
				||
			pelicula.getRecaudacion() == null)
		{
			return "Todos los campos tienen que incluir informacion";
		}
		
		dp.save(pelicula);
		return "La pelicula ha sido insertada en el directorio";

	}

	
}
