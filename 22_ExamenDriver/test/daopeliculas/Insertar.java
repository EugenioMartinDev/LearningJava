package daopeliculas;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

public class Insertar {

	public static void main(String[] args) {
		
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("La guerra de las galaxias");
		pelicula.setDirector("George Lucas");
		pelicula.setGenero("Sci-fi");
		pelicula.setAnio(1977);
		
		DaoPelicula dp = new DaoPelicula();
		dp.alta(pelicula);
		
		System.out.println("Insertada correctamente");

	}

}
