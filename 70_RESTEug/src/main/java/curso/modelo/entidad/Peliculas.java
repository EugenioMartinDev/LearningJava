package curso.modelo.entidad;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//Si pedimos una lista de entidades en formato xml necesitamos anotar la lista.
//Para ello hay que definir un wrapper de la lista, en una clase:
//Esta clase la hacemos para poder anotar la lista de peliculas como xml


@XmlRootElement
public class Peliculas {

	private List<Pelicula> listaPeliculas;

	/**
	 * @return the listaPeliculas
	 */
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	/**
	 * @param listaPeliculas the listaPeliculas to set
	 */
	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	
	
}
