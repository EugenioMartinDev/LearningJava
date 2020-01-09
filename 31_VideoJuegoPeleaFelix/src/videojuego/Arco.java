package videojuego;

import java.util.Random;

public class Arco extends Arma{
	
	public int usar() {
		System.out.println("Siiiiiiuuuuuuu!");
		//from mykong guru
		Random r = new Random();
		return r.nextInt((getDanioMax() - getDanioMin() + 1) + getDanioMin());
	}
}
