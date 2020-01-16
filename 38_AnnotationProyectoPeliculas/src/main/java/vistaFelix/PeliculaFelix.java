package vistaFelix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class PeliculaFelix {

	private String titulo;
	private String genero;
	@Autowired
	private DirectorFelix director;
	private int anioEstreno;
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @return the director
	 */
	public DirectorFelix getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(DirectorFelix director) {
		this.director = director;
	}
	/**
	 * @return the anioEstreno
	 */
	public int getAnioEstreno() {
		return anioEstreno;
	}
	/**
	 * @param anioEstreno the anioEstreno to set
	 */
	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + ", director=" + director + ", anioEstreno="
				+ anioEstreno + "]";
	}

	
	
}
	
