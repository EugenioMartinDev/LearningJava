package curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Operacion;

@Repository
public interface DaoOperacion extends JpaRepository<Operacion, Integer>{

}
