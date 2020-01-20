package modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.entidad.Libro;

@Repository
public interface DaoLibreria extends JpaRepository<Libro, Integer>{
	
}
