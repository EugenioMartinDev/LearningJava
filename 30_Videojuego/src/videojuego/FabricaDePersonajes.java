package videojuego;

public class FabricaDePersonajes {

	// Suele ser estático para evitar crear un objeto de tipo factory
	public static Personaje create(String tipo) {
		
		Personaje personaje = null;
		
		switch (tipo) {
		case "guerrero":
			personaje = new Guerrero();
			break;
		case "mago":
			personaje = new Mago();
			break;
		case "enano":
			personaje = new Enano();
			break;	
		default:
			personaje = null;
			// return null by default
		}
		
		if (personaje != null) {
			personaje.setPotencia(Math.random()*300);
		}
		
		return personaje;
	}
}
