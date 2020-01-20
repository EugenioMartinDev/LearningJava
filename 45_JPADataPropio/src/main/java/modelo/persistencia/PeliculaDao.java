package modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.entidad.Pelicula;

//Para crear ahora el DAO con JPAData debemos crear una interfaz y 
//extenderla de JpaRepository, con dos valores parametrizados: la entidad
//con que queremos trabajar (Pelicula) y el tipo de dato que es el id (Integer)
@Repository
public interface PeliculaDao extends JpaRepository<Pelicula, Integer>{
	
}
