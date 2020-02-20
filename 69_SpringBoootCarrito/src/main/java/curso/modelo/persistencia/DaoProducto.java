package curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Producto;

@Repository
public interface DaoProducto extends JpaRepository<Producto, Integer>{

}
