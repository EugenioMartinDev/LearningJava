package directorio.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import directorio.modelo.entidad.PeliculaBase;



public interface DaoPeliculaBase extends JpaRepository<PeliculaBase, Integer> {

	
    //@Query(" SELECT new ResultTituloPelicula(e.id, e.titulo) FROM listadoPeliculas e ORDER BY titulo ") 
    //public List<PeliculaBase> selectIdAndTitulo();
	
}
