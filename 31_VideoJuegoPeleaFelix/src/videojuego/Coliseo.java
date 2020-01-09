package videojuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Coliseo {

	private List<Personaje> luchadores;
	
	
	
	/**
	 * @return the luchadores
	 */
	public List<Personaje> getLuchadores() {
		return luchadores;
	}

	/**
	 * @param luchadores the luchadores to set
	 */
	public void setLuchadores(List<Personaje> luchadores) {
		this.luchadores = luchadores;
	}

	public Coliseo(List<Personaje> luchadores) {
		this.luchadores = luchadores;		
	}

	public void empezar(Map<String,Integer> victorias) {
		
		boolean imprimir = false;
		
		if (imprimir) System.out.println("BIENVENIDOS AL COMBATE");
		for (Personaje p : luchadores) {
			if (imprimir) System.out.println("Soy el luchador " + p);
		}
		
		boolean acabado = false;
		int turno = 0;
		do {
			
			if (imprimir) if (imprimir) System.out.println("Pulse enter para continuar");
			//new Scanner(System.in).nextLine();
			if (imprimir) System.out.println("********** TURNO " + (++turno) + " **************");
			
			List<Personaje> luchadoresRivales = new ArrayList<Personaje>();
			Personaje luchador; 
			for (int i=0; i<luchadores.size(); i++) {
				luchador = luchadores.get(i);
				luchadoresRivales.clear();
				if (luchador.getVida() > 0)
				{
					for (int j=0; j<luchadores.size(); j++) {
						
						if (!luchador.getNombre().contentEquals(luchadores.get(j).getNombre())) luchadoresRivales.add(luchadores.get(j));
					}
					if (luchadoresRivales.size() > 0)
					{
						int aleatorio = ThreadLocalRandom.current().nextInt(0, luchadoresRivales.size());
						Personaje enfrentado = luchadoresRivales.get(aleatorio);
		
						int danio = luchador.atacar(enfrentado);
						if (imprimir) System.out.println("Daño causado por " + luchador.getNombre() + " sobre " + luchador.getNombre() + " : " + danio);
						if (imprimir) System.out.println("-----------------------------------------------");
					}
				}
			}


			
			List<Personaje> luchadoresVivos = new ArrayList<Personaje>();
			for (Personaje p : luchadores) {
				if (imprimir) System.out.println("La vida del luchador " + p.getNombre() + " es : " + p.getVida());
				if (p.getVida() > 0 ) {
					luchadoresVivos.add(p);
				} else {
					if (imprimir) System.out.println("Ha muerto " + p);
				}
			}
			luchadores = luchadoresVivos;
		
			if (luchadores.size() <= 1) acabado = true;
			
		} while (!acabado);
		
		if (luchadores.size() == 1) {
			if (imprimir) System.out.println("************* El ganador es " + luchadores.get(0));
			victorias.put(luchadores.get(0).getNombre(), victorias.get(luchadores.get(0).getNombre())+1);
		}
		else if (imprimir) System.out.println("************* No hay ningún ganador");
		
	}
	
}
