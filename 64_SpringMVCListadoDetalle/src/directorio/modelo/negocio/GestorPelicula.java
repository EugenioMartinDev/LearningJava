package directorio.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	DaoPelicula dp;
	
	@Autowired
	List<Pelicula> listaTituloPelicula;

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

	
	public List<Object[]> listar() {
		
		return dp.selectIdAndTitulo();

	}


	public Pelicula getPelicula(int id) {
		
		return dp.findById(id).get();
	}
	

	
}
