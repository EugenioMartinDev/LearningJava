package modelo.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.persistencia.DaoPelicula;

public class GestorPeliculas {

	private DaoPelicula daoPelicula;

	
	/**
	 * @return the daoPelicula
	 */
	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	/**
	 * @param daoPelicula the daoPelicula to set
	 */
	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}

	
	/**
	 * @param pelicula
	 * @return 0 : executed without errors
	 *         1 : some field is empty or 0
	 *         2 : error inserting the film
	 * @throws SQLException
	 */
	public int altaPelicula(Pelicula pelicula) throws SQLException {
		
		if (emptyFields(pelicula)) return 1; 
		if (daoPelicula.alta(pelicula)) return 0;
		
		return 2;
	}
	
	/**
	 * @param id
	 * @return 
	 * @throws SQLException 
	 */
	public boolean bajaPelicula(int id) throws SQLException {
		

		return daoPelicula.borrar(id);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Pelicula buscarPelicula(int id) throws SQLException {
		
		Pelicula pelicula = daoPelicula.obtener(id);
		return pelicula;
	}
	
	/**
	 * @param pelicula
	 * @return 0 : executed without errors
	 *         1 : some field is empty or 0
	 *         2 : error inserting the film
	 * @throws SQLException 
	 */
	public  int modificarPelicula(Pelicula pelicula) throws SQLException {
		
		if (emptyFields(pelicula)) return 1;
		if (daoPelicula.modificar(pelicula)) return 0;
		
		return 2;

	}

	/**
	 * @throws SQLException
	 */
	public List<Pelicula> listarPelicula() throws SQLException {
		
		return daoPelicula.listar();
	}
	
	/**
	 * @throws SQLException
	 */
	public List<Pelicula> listarPeliculaOrdenadaAnio() throws SQLException {
		
		return daoPelicula.listarOrdenAnio();
	}
	
	
	private boolean emptyFields(Pelicula pelicula) {
	
		if (pelicula.getTitulo().isEmpty() || pelicula.getDirector().isEmpty() 
				|| pelicula.getGenero().isEmpty() || pelicula.getAnioPublicacion() == 0 ) {
			return true;
		}
		
		return false;
	}

	public ArrayList buscarPeliculaPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList buscarPeliculaPorClave(String text, String campo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
