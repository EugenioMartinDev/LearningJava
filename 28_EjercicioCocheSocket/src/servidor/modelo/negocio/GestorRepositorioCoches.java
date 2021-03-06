package servidor.modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import servidor.modelo.persistencia.DaoCoche;
import utils.Constantes;


public class GestorRepositorioCoches {

	private DaoCoche daoCoche = new DaoCoche();

	/**
	 * @return the daoCoche
	 */
	public DaoCoche getDaoCoche() {
		return daoCoche;
	}

	/**
	 * @param daoCoche the daoCoche to set
	 */
	public void setDaoCoche(DaoCoche daoCoche) {
		this.daoCoche = daoCoche;
	}

	public List<Coche> listarCoches() {
		return daoCoche.getListaCoches();
		
	}

	/**
	 * Dar de alta un coche
	 * @param libro : coche a dar de alta
	 * @return 0 en caso de inserción; 1 en caso de que falte matricula
	 *         2 en caso de que falte marca; 3 en caso de que falte modelo
	 *         4 en caso de matricula duplicada; 5 en caso de fallo de bbdd
	 */
	public int alta(Coche coche) {
		

		if (coche.getMatricula().isEmpty()) {
			return Constantes.ERROR_MATRICULA_IS_NULL;
		}
		
		if (coche.getMarca().isEmpty()) {
			return Constantes.ERROR_MARCA_IS_NULL;
		}
		if (coche.getModelo().isEmpty()) {
			return Constantes.ERROR_MODELO_IS_NULL;
		}
		
		if (daoCoche.buscarPorMatricula(coche.getMatricula()) != null) {
			return Constantes.ERROR_MATRICULA_IS_DUPLICATED;
		}
				
		if (daoCoche.alta(coche)) return Constantes.SUCCESSFULL_EXECUTION;
		else return Constantes.ERROR_IN_DDBB;
		
	}
		
}
