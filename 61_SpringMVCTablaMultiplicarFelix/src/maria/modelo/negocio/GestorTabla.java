package maria.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maria.modelo.entidad.TablaMultiplicar;

@Service
public class GestorTabla {

	@Autowired
	private TablaMultiplicar tabla;
	
	public void calcularTabla() {		
		List<Integer> listaResultado = new ArrayList<Integer>();
		int resultado = 0;
		for (int i=1; i<=10; i++) {
			resultado = i * tabla.getNumero();
			listaResultado.add(resultado);
		}
		tabla.setListaResultados(listaResultado);
	}	
}
