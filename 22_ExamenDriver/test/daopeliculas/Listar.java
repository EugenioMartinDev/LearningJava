package daopeliculas;

import java.util.List;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

public class Listar {

	public static void main(String[] args) {

		DaoPelicula dp = new DaoPelicula();
		
		List<Pelicula> listaPeliculas = dp.listar();
		
		for (Pelicula p : listaPeliculas) {
			System.out.println(p);
		}

	}

}
