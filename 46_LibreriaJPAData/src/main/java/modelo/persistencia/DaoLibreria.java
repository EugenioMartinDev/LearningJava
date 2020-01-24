package modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.entidad.Libro;

public interface DaoLibreria extends JpaRepository<Libro, Integer>{
	
}
