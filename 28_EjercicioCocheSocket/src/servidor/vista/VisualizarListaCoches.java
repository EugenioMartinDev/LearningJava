package servidor.vista;

import java.util.List;

import modelo.entidad.Coche;

public class VisualizarListaCoches {

	public VisualizarListaCoches(List<Coche> listaCoches) {
		
		for (Coche coche : listaCoches) {
			System.out.println(coche);
		}
		
		
	}
	
}
