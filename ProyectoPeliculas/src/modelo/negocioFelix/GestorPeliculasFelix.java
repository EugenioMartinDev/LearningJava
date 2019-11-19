package modelo.negocioFelix;

import java.util.ArrayList;

import vistaFelix.PeliculaFelix;


public class GestorPeliculasFelix {

	private ArrayList<PeliculaFelix> listaPeliculas;

	/**
	 * @return the listaPeliculas
	 */
	public ArrayList<PeliculaFelix> getListaPeliculas() {
		return listaPeliculas;
	}

	/**
	 * @param listaPeliculas the listaPeliculas to set
	 */
	public void setListaPeliculas(ArrayList<PeliculaFelix> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	public void alta(PeliculaFelix pelicula) {		
		listaPeliculas.add(pelicula);		
	}
	
	//Listar pel�culas es una funci�n de la vista
	
	/**
	 * M�todo que busca por t�tulo una pel�cula.
	 * @param titulo : El t�tulo de la pel�cula a buscar
	 * @return : La pel�cula encontrada o un valor null si no se encuentra
	 */
	public PeliculaFelix buscarPorTitulo(String titulo) {
		for (PeliculaFelix pelicula : listaPeliculas) {
			if (pelicula.getTitulo().equals(titulo))
				return pelicula;
		}		
		return null;
	}
	
	
	
}
