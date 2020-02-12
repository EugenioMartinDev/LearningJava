package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Pelicula;
import curso.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	private DaoPelicula dp;
	
	public void alta(Pelicula p) {
		dp.save(p);
	}
	
	
	public List<Pelicula> listar() {
		return dp.findAll();
	}
	
	public Pelicula getPeliculaById(int id) {
		return dp.findById(id).get();
	}
	
}
