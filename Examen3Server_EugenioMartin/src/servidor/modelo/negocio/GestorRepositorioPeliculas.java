package servidor.modelo.negocio;

import java.util.List;

import modelo.entidad.Pelicula;
import servidor.modelo.persistencia.DaoPelicula;
import utils.Constantes;


public class GestorRepositorioPeliculas {

	private DaoPelicula daoPelicula = new DaoPelicula();

	/**
	 * @return the daoCoche
	 */
	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	/**
	 * @param daoCoche the daoCoche to set
	 */
	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}

	public List<Pelicula> listarPeliculas() {
		return daoPelicula.listar();
		
	}
	
	
	
	/**
	 * Lógica de desempaquetado de los datos recibidos por el socket
	 * @param datosPelicula
	 * @return	ERROR_TITULO_IS_NULL = 1;
	 *          ERROR_DIRECTOR_IS_NULL = 2; 	
	 * 			ERROR_WRONG_MISSING_PARAMETERS = 6;
	 *          ERROR_UNKNOWN_OPERATION = 7;
	 *          ERROR_INSUFICIENT_PARAMETERS = 8;
	 *          ERROR_ID_IS_NULL = 9;
	 */
	public int unpackInfo(String[] datosPelicula) {

		if (datosPelicula.length <= 1) return Constantes.ERROR_WRONG_MISSING_PARAMETERS;
		
		datosPelicula[0] = datosPelicula[0].toUpperCase();
		
		if (!"ALTA".contentEquals(datosPelicula[0]) 
			 &&
				!"BAJA".contentEquals(datosPelicula[0]) 
				&&
				!"BUSQUEDA".contentEquals(datosPelicula[0]))
		{
			return Constantes.ERROR_UNKNOWN_OPERATION;
		}
		
		if ("ALTA".contentEquals(datosPelicula[0]))
		{
			if (datosPelicula.length != 3) return Constantes.ERROR_INSUFICIENT_PARAMETERS;
			
			if (datosPelicula[1].isEmpty()) {
				return Constantes.ERROR_TITULO_IS_NULL;
			}
			
			if (datosPelicula[2].isEmpty()) {
				return Constantes.ERROR_DIRECTOR_IS_NULL;
			}
		} else {
			if (datosPelicula.length != 2) return Constantes.ERROR_INSUFICIENT_PARAMETERS;
			
			if (datosPelicula[1].isEmpty()) {
				return Constantes.ERROR_ID_IS_NULL;
			}
		}


		
		return Constantes.SUCCESSFULL_EXECUTION;
	}

	/**
	 * Dar de alta una pelicula
	 * @param Pelicula : pelicula a dar de alta
	 * @return 0 en caso de inserción; 1 en caso de que falte el título
	 *         2 en caso de que falte el director; 3 en caso de que no se encuentre una película
	 *           en el catálogo; 4 en caso de fallo de bbdd; 5 la pelicula ya existe en el catálogo
	 */
	public int alta(Pelicula pelicula) {
				
		Pelicula peliculaBuscada = daoPelicula.obtenerPorTitulo(pelicula.getTitulo());
		
		if (peliculaBuscada != null)
		{
			if (peliculaBuscada.getTitulo().contentEquals(pelicula.getTitulo())
					&&
					peliculaBuscada.getDirector().contentEquals(pelicula.getDirector()))
			{
				return Constantes.ERROR_PELICULA_DUPLICATED;
			}
		}
			
		if (daoPelicula.alta(pelicula)) return Constantes.SUCCESSFULL_EXECUTION;
		else return Constantes.ERROR_IN_DDBB;
		
	}
		
	
	public Pelicula buscar(int id) {		
		return daoPelicula.obtener(id);
	}

	public boolean baja(int id) {
		return daoPelicula.borrar(id);
	}
	
}
