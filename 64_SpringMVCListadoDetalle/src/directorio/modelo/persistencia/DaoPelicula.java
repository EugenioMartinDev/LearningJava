package directorio.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import directorio.modelo.entidad.Pelicula;


@Repository
public interface DaoPelicula extends JpaRepository<Pelicula, Integer> {

	@Query("SELECT p.id, p.titulo FROM Pelicula p ORDER BY p.titulo")
	public List<Object[]> selectIdAndTitulo();
    //@Query(" SELECT new ResultTituloPelicula(e.id, e.titulo) FROM listadoPeliculas e ORDER BY titulo ") 
    //public List<Pelicula> selectIdAndTitulo();
	
}
