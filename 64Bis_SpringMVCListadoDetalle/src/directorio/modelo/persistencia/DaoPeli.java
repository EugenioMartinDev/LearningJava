package directorio.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import directorio.modelo.entidad.Peli;
import directorio.modelo.entidad.Pelicula;



public interface DaoPeli extends JpaRepository<Peli, Integer> {

	//JPQL
    @Query("SELECT p.id, p.titulo FROM Peli p") 
    public List<Object[]> selectIdAndTitulo();
	
}
