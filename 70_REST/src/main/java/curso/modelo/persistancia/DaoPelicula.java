package curso.modelo.persistancia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Pelicula;

@Repository
public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{

}
