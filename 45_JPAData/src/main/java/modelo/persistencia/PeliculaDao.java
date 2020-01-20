package modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.entidad.Pelicula;

//Para crear ahora el dao con JPAData debemos
//de crear una intefaz y extenderla de JpaRepository
//y tiene dos valores parametrizados, uno es el tipo de 
//entidad con el que queremos trabajar (Pelicula) y el otro seria
//el tipo de dato que es el id, en nuestro caso es Integer
@Repository
public interface PeliculaDao 
	extends JpaRepository<Pelicula, Integer>{

}
