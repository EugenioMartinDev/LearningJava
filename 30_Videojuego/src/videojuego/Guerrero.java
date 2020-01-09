package videojuego;

public class Guerrero extends Personaje{


	public void atacar() {
		System.out.println("Soy el guerrero " + this.getNombre() + ".. ARGGGGGG!!!");
		this.getArma().usar();
	}
	
	
	
}
