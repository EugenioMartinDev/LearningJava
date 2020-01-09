package videojuego;

public class FabricaPersonajes {

	public static Personaje crear(String tipo) {
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
			break;
		}
		
		return personaje;
	}
	
}
