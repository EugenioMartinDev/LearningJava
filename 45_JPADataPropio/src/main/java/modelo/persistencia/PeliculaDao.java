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
	 *  Para hacer consultas espec�ficas, podemos hacerlas dentro de esta interfaz, y sigue una metodolog�a
	 *  que se suele llamar convenci�n frente a configuraci�n que tambi�n ser� uno de los principio de 
	 *  SpringBoot.
	 *  
	 *  Por ejemplo, si el m�todo empieza por findBy har� una b�squeda. Si luego pongo la propiedad que deseo,
	 *  har� la b�squeda por esa propiedad. Si no, habr� que picar la query a mano.
	 */
	
	public List<Pelicula> findByTitulo(String titulo);
	public List<Pelicula> findByTituloAndGenero(String titulo, String genero);
	public List<Pelicula> findByTituloOrGenero(String titulo, String genero);
	
	public List<Pelicula> findByTituloContaining(String titulo);
	
	public List<Pelicula> findByTituloOrderByTituloAsc(String titulo);
	public List<Pelicula> findByTituloOrderByTituloDesc(String titulo);
	
	public List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
	
	// Esto es JPQL, una mezcla entre sql y poo (programaci�n orientada a objetos)
	@Query("select p from Pelicula p where p.genero=?1")
	public List<Pelicula> findByMiBusquedaDeGenero(String genero);
}
