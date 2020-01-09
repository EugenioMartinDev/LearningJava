package videojuego;

//El patron factory centraliza la creación (new) de objetos de un mismo tipo. La clase que centraliza tendrá todas las dependencias fuertes de esa clase.
public class FabricaDeArmas {

	// Suele ser estático para evitar crear un objeto de tipo factory
	public static Arma create(String tipo) {
		
		Arma arma = null;
		
		switch (tipo) {
		case "espada":
			arma = new Espada();
			arma.setTipo(tipo);
			break;
		case "arco":
			arma = new Arco();
			arma.setTipo(tipo);
			break;
		case "hacha":
			arma = new Hacha();
			arma.setTipo(tipo);
			break;
		case "durmiente":
			arma = new Durmiente();
			break;
		case "estatua":
			arma = new Estatua();
			break;
		case "metamorfo":
			arma = new Metamorfo();
			break;
		case "chisteverde":
			arma = new ChisteVerde();
			break;
		case "chisteblanco":
			arma = new ChisteBlanco();
			break;
		default:
			arma = null;
			// return null by default
		}
		
		if (arma != null) {
			arma.setValor(Math.random()*100);
		}
		
		return arma;
	}
}
