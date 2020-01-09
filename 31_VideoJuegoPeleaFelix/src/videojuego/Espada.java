package videojuego;

import java.util.Random;

public class Espada extends Arma{

	
	public int usar() {
		System.out.println("Swaaaaanggg");
		//from mykong guru
		Random r = new Random();
		return r.nextInt((getDanioMax() - getDanioMin() + 1) + getDanioMin());
	}

	
}
