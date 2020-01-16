package modelo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pelicula {
	private String titulo;
	private String genero;
	@Autowired
	private Director Director;
	private int anioEstreno;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Director getDirector() {
		return Director;
	}
	public void setDirector(Director director) {
		Director = director;
	}
	public int getAnioEstreno() {
		return anioEstreno;
	}
	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + ", Director=" + Director + ", anioEstreno="
				+ anioEstreno + "]";
	}
}
