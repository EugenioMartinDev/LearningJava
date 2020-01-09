package cliente.modelo.negocio;

import cliente.modelo.entidad.Pelicula;
import cliente.modelo.persistencia.DaoClientePelicula;

public class GestorClientePeliculas {

	DaoClientePelicula daoPelis = new DaoClientePelicula();
	
	public void alta(String id, String titulo, String director) {
		daoPelis.socketAlta(id, titulo, director);
	}
	
	public int baja(String id) {
		return daoPelis.socketBorrarId(id);
	}
	
	public Pelicula buscar(String id) {
		return daoPelis.socketBusquedaId(id);
	}
	
}
