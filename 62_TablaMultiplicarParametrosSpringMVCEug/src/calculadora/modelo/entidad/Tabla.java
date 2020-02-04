package calculadora.modelo.entidad;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Tabla {

	private int numero;
	private List<Integer> tablaMultiplicar;
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
	/**
	 * @return the tablaMultiplicar
	 */
	public List<Integer> getTablaMultiplicar() {
		return tablaMultiplicar;
	}
	/**
	 * @param tablaMultiplicar the tablaMultiplicar to set
	 */
	public void setTablaMultiplicar(List<Integer> tablaMultiplicar) {
		this.tablaMultiplicar = tablaMultiplicar;
	}
	@Override
	public String toString() {
		return "Tabla [numero=" + numero + ", tablaMultiplicar=" + tablaMultiplicar + "]";
	}
	
	
	
}
