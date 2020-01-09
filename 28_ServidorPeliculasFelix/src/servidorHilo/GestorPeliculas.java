package servidorHilo;

import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
	
	private List<Pelicula> listaPeliculas;
	
	public GestorPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public void alta(Pelicula p) {
		listaPeliculas.add(p);
		System.out.println("Peliculas hasta la fecha...");
		System.out.println(listaPeliculas);
	}
	
	public Pelicula buscar(String id) {
		for(Pelicula pelicula : listaPeliculas) {
			if(pelicula.getId().equals(id)) {
				return pelicula;
			}
		}
		
		return null;
	}
	
	public int baja(String id) {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(id);
		boolean borrado = listaPeliculas.remove(pelicula);
		if(borrado) {
			return 0;
		}else {
			return 1;
		}
	}
}
