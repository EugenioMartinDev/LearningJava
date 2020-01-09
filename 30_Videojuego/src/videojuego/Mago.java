package videojuego;

public class Mago extends Personaje {

	public void atacar() {
		System.out.println("Soy el mago " + this.getNombre() + ".. HuuuuuuG!!!");
		this.getArma().usar();
	}


}
