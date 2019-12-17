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
	 *  M�todo que se encarga de dar de alta una pel�cula
	 *  @param pelicula a dar de alta
	 *  @return 0 si se ha insertado, 1 si alg�n campo est� vac�o,
	 *          2 si hay dos pel�cula con el mismo t�tulo
	 *          3 si falla el alta en la base de datos
	 */
	public int alta(Pelicula pelicula) {
		
		if (!comprobarCamposVac�os(pelicula)) return 1;
		
		if (comprobarTituloRepetido(pelicula.getTitulo())) return 2;
		
		boolean correcto = daoPelicula.alta(pelicula);
		if (correcto) {
			return 0;
		} else return 3;
	}
	
	/**
	 *  M�todo que se encarga de modificar una pel�cula
	 *  @param pelicula a dar de alta
	 *  @return 0 si se ha insertado, 1 si alg�n campo est� vac�o,
	 *          2 si hay dos pel�cula con el mismo t�tulo
	 *          3 si falla el alta en la base de datos
	 */
	public int modificar(Pelicula pelicula) {
		
		if (!comprobarCamposVac�os(pelicula)) return 1;
		
		if (comprobarTituloRepetido(pelicula.getTitulo())) return 2;
		
		boolean correcto = daoPelicula.modificar(pelicula);
		if (correcto) {
			return 0;
		} else return 3;
		
	}

	
	/**
	 * M�todo para borrar una pel�cula seg�n la identidad
	 * @param id
	 * @return
	 */
	public boolean borrar(int id) {
		
		return daoPelicula.borrar(id);		
	}
	
	
	/**
	 * M�todo para obtener una pel�cula seg�n la identidad
	 * @param id
	 * @return una pel�cula
	 */
	public Pelicula obtener(int id) {
		
		return daoPelicula.obtener(id);
	}
	
	
	/**
	 * M�todo para listar todas las pel�culas en la BBDD
	 * @return lista de pel�culas
	 */
	public List<Pelicula> listar() {
		
		return daoPelicula.listar();
		
	}
	
	/**
	 * M�todo que comprueba si hay alg�n campo vac�o en la pel�cula
	 * @param pelicula
	 * @return <b>false</b> si hay alg�n campo vac�o
	 *         <b>true</b> si todos est�n rellenos
	 */
	private boolean comprobarCamposVac�os(Pelicula pelicula) {
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
	 * M�todo que comprueba si existe un titulo en bbdd
	 * @param titulo
	 * @return <b>false</b> en caso de que el t�tulo no est� repetido
	 *         <b>true</b> en case de que est� repetido
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
