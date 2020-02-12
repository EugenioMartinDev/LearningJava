package directorio.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import directorio.modelo.entidad.Pelicula;



public interface DaoPelicula extends JpaRepository<Pelicula, Integer> {

	//JPQL
    //@Query("SELECT p.id, p.titulo FROM Pelicula p") 
    //public List<Object[]> selectIdAndTitulo();
	
}
