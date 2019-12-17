package daopeliculas;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

public class Modificar {

	public static void main(String[] args) {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(1);
		pelicula.setTitulo("La guerra de las galaxias");
		pelicula.setDirector("George Lucas");
		pelicula.setGenero("Sci-fi");
		pelicula.setAnio(1975);
		
		DaoPelicula dp = new DaoPelicula();
		dp.modificar(pelicula);
		
		System.out.println("Modificada correctamente");

	}

}
