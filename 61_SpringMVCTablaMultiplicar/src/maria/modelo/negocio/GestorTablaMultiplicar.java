package maria.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maria.modelo.entidad.TablaMultiplicar;

@Service
public class GestorTablaMultiplicar {

	@Autowired
	private TablaMultiplicar tm;
	
	public void calcularTablaMultiplicar() {
		List<Integer> listaResultado = new ArrayList<Integer>();
		for(int i=1;i<=10;i++) {
			int resultado = i * tm.getNumero();
			listaResultado.add(resultado);
		}
		
		tm.setListaResultados(listaResultado);		
	}
}
