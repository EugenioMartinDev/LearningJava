package login.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import login.modelo.entidad.Login;



public interface DaoLibreria extends JpaRepository<Login, Integer>{
	
}
