package entidad;

public class Pelicula {

	/*
	Ejercicio Peliculas
	Quiero hacer una aplicacion en la que mostremos un menu tal como sigue
	1 - Alta Pelicula
	2 - Listar pelicula
	3 - Buscar Pelicula por titulo
	0 - salir el programa
	
	Quiero guardar en un array list todas la peliculas que se vayan dando de alta. 
	Que quiero guardar dentro de una pelicula
		titulo
		genero
		director
		año de estreno
	Del director quiero guardar 2 cosas
	 	nombre
		edad
	A la hora de listar se mostrarán todos los datos de todas las peliculas que haya dado del alta el usuario
	Cuando busquemos una pelicula por titulo deberemos de mostrar toda la información relevante a la pelicula
		
	}
	
	*/
	
	private String titulo;
	private String genero;
	private Director director;
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
	public Director getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(Director director) {
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
	
