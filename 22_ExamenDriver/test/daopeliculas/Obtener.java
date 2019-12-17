package daopeliculas;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

public class Obtener {

	public static void main(String[] args) {
		
		DaoPelicula dp = new DaoPelicula();
		
		Pelicula pelicula = dp.obtener(1);
		
		System.out.println(pelicula);
		
	}

	
	
	
}
