package login.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import login.modelo.entidad.Login;


@Repository
@RequestScope
public interface DaoLogin extends JpaRepository<Login, Integer>{
	
}
