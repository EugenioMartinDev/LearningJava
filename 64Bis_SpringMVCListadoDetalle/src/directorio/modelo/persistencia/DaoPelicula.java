package directorio.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.entidad.PeliculaBase;


public interface DaoPelicula extends JpaRepository<PeliculaBase, Integer> {

	
    //@Query(" SELECT new ResultTituloPelicula(e.id, e.titulo) FROM listadoPeliculas e ORDER BY titulo ") 
    //public List<PeliculaBase> selectIdAndTitulo();
	
}
