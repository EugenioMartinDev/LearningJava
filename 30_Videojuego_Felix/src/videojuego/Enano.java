package videojuego;

public class Enano extends Personaje {

	public void atacar() {
		System.out.println("Soy el enano " + getNombre()+ ".. ahiVo ahivo!!!!");
		getArma().usar();
	}
	
}
