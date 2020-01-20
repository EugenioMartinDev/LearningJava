package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidad.Pelicula;
import modelo.persistencia.PeliculaDao;

@Service
public class GestorPelicula {

	@Autowired
	private PeliculaDao peliculaDao;
	
	@Transactional
	public Pelicula alta(Pelicula p) {
		return peliculaDao.save(p); //Pelicula no contiene id : la genera la bbdd
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return peliculaDao.save(p); //Pelicula sí contiene id : la bbdd la encuentra y actualiza sus datos
	}
	
	public Pelicula obtener(int id) {
		return peliculaDao.findById(id).get();
	}
	
	public List<Pelicula> listar() {
		return peliculaDao.findAll();
	}
	
	@Transactional
	public void borrar(int id) {
		peliculaDao.deleteById(id);
	}
}
