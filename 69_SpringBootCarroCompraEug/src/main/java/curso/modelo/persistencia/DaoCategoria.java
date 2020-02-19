package curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Categoria;
import curso.modelo.entidad.Producto;


@Repository
public interface DaoCategoria extends JpaRepository<Categoria, Integer>{
	
	public Categoria findByNombre(String categoria);

}
