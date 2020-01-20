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
	
    @Query("SELECT t FROM Libro t where t.isbn = :isbn") 
    Optional<Libro> findTitleByIsbn(@Param("isbn") String isbn);
    
    @Query("SELECT t FROM Libro t where t.editorial = :editorial") 
    List<Libro> findTitleByEditorial(@Param("editorial") String editorial);
	
}
