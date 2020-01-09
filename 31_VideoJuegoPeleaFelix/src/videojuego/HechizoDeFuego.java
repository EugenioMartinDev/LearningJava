package videojuego;

import java.util.Random;

public class HechizoDeFuego extends Arma {

	@Override
	public int usar() {
		System.out.println("Fireball !!!!");
		//from mykong guru
		Random r = new Random();
		return r.nextInt((getDanioMax() - getDanioMin() + 1) + getDanioMin());
	}
	
	

}
