package daopeliculas;

import modelo.persistencia.DaoPelicula;

public class Borrar {

	public static void main(String[] args) {
		
		DaoPelicula dp = new DaoPelicula();
		
		boolean borrado = dp.borrar(1);
		
		System.out.println("Borrado " + borrado);

	}

}
