package interfaces;

import java.util.ArrayList;
import java.util.List;

public class MainInterfaces {

	public static void main(String[] args) {
		
		//m s�lo tiene accesibles los m�todos de la interfaz Movible. No se puede cambiar el nombre.
		Movible m = new Oso();
		
		List<Movible> listaMovibles = new ArrayList<Movible>();
		listaMovibles.add(m);
		
		Oso o = new Oso();
		listaMovibles.add(o);
		
		Persona p = new Persona();
		listaMovibles.add(p);
		
		

	}

}
