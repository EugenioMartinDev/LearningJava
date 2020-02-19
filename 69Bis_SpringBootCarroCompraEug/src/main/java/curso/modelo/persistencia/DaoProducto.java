package curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Categoria;
import curso.modelo.entidad.Producto;


@Repository
public interface DaoProducto extends JpaRepository<Producto, Integer>{
	
	public Producto findByNombre(String nombre);
	
	public List<Producto> findByCategoria(Categoria categoria);

}
