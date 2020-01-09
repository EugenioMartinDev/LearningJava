package videojuego;

public class Enano extends Personaje {

	public void atacar() {
		System.out.println("Soy el enano " + this.getNombre() + ".. JaaaJaja!!!");
		this.getArma().usar();
	}
	
}
