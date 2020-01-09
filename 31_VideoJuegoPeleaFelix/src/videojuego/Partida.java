package videojuego;

import java.util.Scanner;

public class Partida {

	private Personaje p1;
	private Personaje p2;
	/**
	 * @param p1
	 * @param p2
	 */
	public Partida(Personaje p1, Personaje p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void empezar() {
		
		System.out.println(" Comienza la batalla ");
		System.out.println(p1);
		System.out.println(p2);
		
		boolean acabada = false;
		int turno = 0;
		Personaje personajeGanador = null;
		do {
			System.out.println("Pulse enter para continuar");
			new Scanner(System.in).nextLine();
			System.out.println("********** TURNO " + (++turno) + " **************");
			
			int resultado = p1.atacar(p2);
			System.out.println("Daño causado por " + p1.getNombre() + " sobre " + p2.getNombre() + " : " + resultado);
			System.out.println("-----------------------------------------------");
			resultado = p2.atacar(p1);
			System.out.println("Daño causado por " + p2.getNombre() + " sobre " + p1.getNombre() + " : " + resultado);
			
			System.out.println("Vida del primer jugador " + p1.getVida());
			System.out.println("Vida del segundo jugador " + p2.getVida());
			
			if (p1.getVida() <= 0) {
				personajeGanador = p2;
				if (p2.getVida() <= 0) {
					System.out.println("Ambos han muerto");
					return;
				}
			} else {
				if (p2.getVida() <= 0) {
					personajeGanador = p1;
				}
			}
			
		} while (personajeGanador == null);
		
		System.out.println("!!!! Tenemos un ganador " + personajeGanador);
		
	}
	
}
