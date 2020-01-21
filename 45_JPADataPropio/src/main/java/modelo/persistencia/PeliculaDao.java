package modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import modelo.entidad.Pelicula;

//Para crear ahora el DAO con JPAData debemos crear una interfaz y 
//extenderla de JpaRepository, con dos valores parametrizados: la entidad
//con que queremos trabajar (Pelicula) y el tipo de dato que es el id (Integer)
@Repository
public interface PeliculaDao extends JpaRepository<Pelicula, Integer>{
	
	/**
	 * 
	 *  Para hacer consultas específicas, podemos hacerlas dentro de esta interfaz, y sigue una metodología
	 *  que se suele llamar convención frente a configuración que también será uno de los principio de 
	 *  SpringBoot.
	 *  
	 *  Por ejemplo, si el método empieza por findBy hará una búsqueda. Si luego pongo la propiedad que deseo,
	 *  hará la búsqueda por esa propiedad. Si no, habrá que picar la query a mano.
	 */
	
	public List<Pelicula> findByTitulo(String titulo);
	public List<Pelicula> findByTituloAndGenero(String titulo, String genero);
	public List<Pelicula> findByTituloOrGenero(String titulo, String genero);
	
	public List<Pelicula> findByTituloContaining(String titulo);
	
	public List<Pelicula> findByTituloOrderByTituloAsc(String titulo);
	public List<Pelicula> findByTituloOrderByTituloDesc(String titulo);
	
	public List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
	
	// Esto es JPQL, una mezcla entre sql y poo (programación orientada a objetos)
	@Query("select p from Pelicula p where p.genero=?1")
	public List<Pelicula> findByMiBusquedaDeGenero(String genero);
}
