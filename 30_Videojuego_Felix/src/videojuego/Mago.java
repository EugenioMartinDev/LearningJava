package videojuego;

public class Mago extends Personaje{
	
	public void atacar() {
		System.out.println("Soy el mago " + getNombre()+ ".. ala Kazan!!!!");
		getArma().usar();
	}

}
