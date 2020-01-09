package videojuego;

public class ChisteBlanco extends Arma {
	
	@Override
	public void usar() {
		System.out.println("Chiste número " + this.getTipo());
		
	}

}
