package curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Libro;

@Repository
public interface DaoLibro extends JpaRepository<Libro, Integer> {

	Libro findByIsbn(String isbn);
	List<Libro> findByAutorAndTitulo(String autor, String titulo);

}
