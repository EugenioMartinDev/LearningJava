package maria.modelo.entidad;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
//El alcance de este objeto tiene un ciclo de vida igual al de su petición HTTP.
@RequestScope
public class TablaMultiplicar {

	private List<Integer> listaResultados;
	private int numero;
	/**
	 * @return the listaResultados
	 */
	public List<Integer> getListaResultados() {
		return listaResultados;
	}
	/**
	 * @param listaResultados the listaResultados to set
	 */
	public void setListaResultados(List<Integer> listaResultados) {
		this.listaResultados = listaResultados;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "TablaMultiplicar [listaResultados=" + listaResultados + ", numero=" + numero + "]";
	}
	
	
	
}
