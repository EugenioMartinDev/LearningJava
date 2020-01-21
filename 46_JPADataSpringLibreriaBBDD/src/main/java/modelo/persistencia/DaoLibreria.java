package modelo.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import modelo.entidad.Libro;

@Repository
public interface DaoLibreria extends JpaRepository<Libro, Integer>{
	
	/**
	 * 
	 *  Para hacer consultas espec�ficas, podemos hacerlas dentro de esta interfaz, y sigue una metodolog�a
	 *  que se suele llamar convenci�n frente a configuraci�n que tambi�n ser� uno de los principio de 
	 *  SpringBoot
	 */
	
	Libro findByIsbn(String isbn);
	
	/* Es lo mismo que hacer 
     @Query("SELECT t FROM Libro t where t.isbn = :isbn") 
    Optional<Libro> findTitleByIsbn(@Param("isbn") String isbn);
    */
    
    List<Libro> findByEditorial(String editorial);
    
    /* Es lo mismo que hacer 
    @Query("SELECT t FROM Libro t where t.editorial = :editorial") 
    List<Libro> findTitleByEditorial(@Param("editorial") String editorial);
	*/
}
