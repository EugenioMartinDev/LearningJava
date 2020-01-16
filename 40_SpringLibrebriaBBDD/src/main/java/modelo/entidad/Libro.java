package modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Libro {

	private String isbn;
	private String titulo;
	private String editorial;
	private int anioPublicacion;
	private int id;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
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
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}
	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	/**
	 * @return the anioPublicacion
	 */
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	/**
	 * @param anioPublicacion the anioPublicacion to set
	 */
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial + ", anioPublicacion="
				+ anioPublicacion + ", id=" + id + "]";
	}
	
	
	
}
