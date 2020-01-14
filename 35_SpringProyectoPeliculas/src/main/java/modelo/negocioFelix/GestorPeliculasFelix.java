package modelo.negocioFelix;

import java.util.ArrayList;

import vistaFelix.PeliculaFelix;


public class GestorPeliculasFelix {

	private ArrayList<PeliculaFelix> listaPeliculas = null;

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
	
	/**
	 * M�todo que da de alta una pel�cula
	 * @param pelicula : representa la pel�cula a dar de alta
	 */
	public boolean alta(PeliculaFelix pelicula) {	
		// Si tenemos alg�n requisito funcionales o validaciones
		// debe ir al menos en la parte de negocio.
		// Se puede meter en la vista pero de manera opcional.
		if (pelicula.getTitulo().length() >= 5) {
			listaPeliculas.add(pelicula);
			return true;
		} else return false;		
	}
	
	/**
		Listar pel�culas es una funci�n de la vista	 
	 */
	
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
	
	
	/**
	 * M�todo que busca por g�nero una pel�cula.
	 * @param genero : El g�nero de la pel�cula a buscar
	 * @return : Todas las pel�culas encontradas por g�nero o una lista vac�a si no se encuentra ninguna
	 */
	public ArrayList<PeliculaFelix> buscarPorGenero(String genero) {		
		ArrayList<PeliculaFelix> listaEncontrada = new ArrayList<PeliculaFelix>();
		for (PeliculaFelix pelicula : listaPeliculas) {
			if (pelicula.getGenero().equals(genero))
				listaEncontrada.add(pelicula);
		}		
		return listaEncontrada;
	}
	
	
}
