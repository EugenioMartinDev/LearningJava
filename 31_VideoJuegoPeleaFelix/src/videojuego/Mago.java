package videojuego;

import java.util.Random;

public class Mago extends Personaje{
	
	public int atacar(Personaje p) {
		
		boolean imprimir = false;
		if (imprimir) System.out.println(" Soy " + getNombre() + " y voy a atacar a " + p.getNombre());
		int danio = getArma().usar();
		//Los magos pueden hacer un ataque cr�tico que hace el doble de da�o, con un 30% de probabilidades
		Random r = new Random();
		int aleatorio = r.nextInt((100 - 1) + 1) + 1;
		if (aleatorio <= 30) {
			if (imprimir) System.out.println("Da�o cr�tico : toma jeroma");
			danio = danio*2;
		}
		int vidaActual = p.getVida() - danio;
		p.setVida(vidaActual);
		return danio;
		
	}

}
