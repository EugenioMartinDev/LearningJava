package modelo.negocio;

import java.util.List;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

/**
 * @author aula2m
 *
 */
/**
 * @author aula2m
 *
 */
/**
 * @author aula2m
 *
 */
public class GestorPelicula {

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
	 *  Método que se encarga de dar de alta una película
	 *  @param pelicula a dar de alta
	 *  @return 0 si se ha insertado, 1 si algún campo está vacío,
	 *          2 si hay dos película con el mismo título
	 *          3 si falla el alta en la base de datos
	 */
	public int alta(Pelicula pelicula) {
		
		if (!comprobarCamposVacíos(pelicula)) return 1;
		
		if (comprobarTituloRepetido(pelicula.getTitulo())) return 2;
		
		boolean correcto = daoPelicula.alta(pelicula);
		if (correcto) {
			return 0;
		} else return 3;
	}
	
	/**
	 *  Método que se encarga de modificar una película
	 *  @param pelicula a dar de alta
	 *  @return 0 si se ha insertado, 1 si algún campo está vacío,
	 *          2 si hay dos película con el mismo título
	 *          3 si falla el alta en la base de datos
	 */
	public int modificar(Pelicula pelicula) {
		
		if (!comprobarCamposVacíos(pelicula)) return 1;
		
		if (comprobarTituloRepetido(pelicula.getTitulo())) return 2;
		
		boolean correcto = daoPelicula.modificar(pelicula);
		if (correcto) {
			return 0;
		} else return 3;
		
	}

	
	/**
	 * Método para borrar una película según la identidad
	 * @param id
	 * @return
	 */
	public boolean borrar(int id) {
		
		return daoPelicula.borrar(id);		
	}
	
	
	/**
	 * Método para obtener una película según la identidad
	 * @param id
	 * @return una película
	 */
	public Pelicula obtener(int id) {
		
		return daoPelicula.obtener(id);
	}
	
	
	/**
	 * Método para listar todas las películas en la BBDD
	 * @return lista de películas
	 */
	public List<Pelicula> listar() {
		
		return daoPelicula.listar();
		
	}
	
	/**
	 * Método que comprueba si hay algún campo vacío en la película
	 * @param pelicula
	 * @return <b>false</b> si hay algún campo vacío
	 *         <b>true</b> si todos están rellenos
	 */
	private boolean comprobarCamposVacíos(Pelicula pelicula) {
		if (pelicula.getTitulo().isEmpty()) {
			return false;
		} else if (pelicula.getDirector().isEmpty()) {
			return false;
		} else if (pelicula.getGenero().isEmpty()) {
			return false;
		} else if (pelicula.getAnio() == 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Método que comprueba si existe un titulo en bbdd
	 * @param titulo
	 * @return <b>false</b> en caso de que el título no esté repetido
	 *         <b>true</b> en case de que esté repetido
	 */
	private boolean comprobarTituloRepetido(String titulo) {
		
		for (Pelicula p : daoPelicula.listar()) {
			if (p.getTitulo().equals(titulo)) {
				return true;
			}
		}
		
		return false;
		
	}
}
