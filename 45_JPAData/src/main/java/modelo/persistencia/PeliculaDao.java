package modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

	//para hacer consultas especificas, podemos hacerlas 
	//dentro de esta interfaz, y sigue una metodologia
	//que se suele llamar, convención frente a configuracion
	//que tambien sera uno de los principios de springboot
	
	//por ejemplo, si el metodo empieza por findBy
	//hara una busqueda. Si luego pongo la propiedad que quiero
	//hara la busqueda por esa propiedad
	
	public List<Pelicula> findByTitulo(String titulo);
	public List<Pelicula> findByTituloAndGenero(String titulo,String genero);
	public List<Pelicula> findByTituloOrGenero(String titulo,String genero);
	
	//peliculas cuyo titulo contenga el titulo pasado
	public List<Pelicula> findByTituloContaining(String titulo);
	
	public List<Pelicula> findByTituloOrderByTituloAsc(String titulo);
	public List<Pelicula> findByTituloOrderByTituloDesc(String titulo);
	
	public List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
	
	//Esto es JPQL, una mezcla entre sql y poo (programacion orientada a objetos)
	@Query("select p from Pelicula p where p.genero=?1")
	public List<Pelicula> findByLoQueMeDeLaGana(String genero);
}




