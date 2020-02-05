package maria.modelo.entidad;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
//El alcance de este objeto ahora es de tipo request
//es decir, su ciclo de vida dura lo que dura una peticion http
@RequestScope
public class TablaMultiplicar {
	private List<Integer> listaResultados;
	private int numero;
	
	public List<Integer> getListaResultados() {
		return listaResultados;
	}
	public void setListaResultados(List<Integer> listaResultados) {
		this.listaResultados = listaResultados;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "TablaMultiplicar [listaResultados=" + listaResultados + ", numero=" + numero + "]";
	}
	
	
}
