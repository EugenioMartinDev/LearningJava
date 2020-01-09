package videojuego;

public class Estatua extends Arma {

	@Override
	public void usar() {		
		System.out.println("Zass ... Te quedarás de piedra " + this.getTipo());	
		
	}
	
}
