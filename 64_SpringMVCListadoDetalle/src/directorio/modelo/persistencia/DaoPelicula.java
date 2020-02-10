package directorio.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import directorio.modelo.entidad.Pelicula;
import directorio.modelo.entidad.Usuario;

public interface DaoPelicula extends JpaRepository<Pelicula, Integer> {

}
