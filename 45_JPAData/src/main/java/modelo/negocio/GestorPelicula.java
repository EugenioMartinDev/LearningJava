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
		//si no le pasamos el id, crea uno nuevo
		return peliculaDao.save(p);
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		//si le pasamos el id, actualiza el registro
		//con dicho id
		return peliculaDao.save(p);
	}
	
	public Pelicula obtener(int id) {
		return peliculaDao.findById(id).get();
	}
	
	public List<Pelicula> listar(){
		return peliculaDao.findAll();
	}
	
	@Transactional
	public void borrar(int id) {
		peliculaDao.deleteById(id);
	}
}
