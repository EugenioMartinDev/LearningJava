package videojuego;

public class MainVideojuego {

	public static void main(String[] args) {
		
		
		Guerrero g1 = new Guerrero();
		g1.setNombre("conan");
		
		//Gracias a usar abstraciones y patrones (fabrica)
		//podemos crear objetos diferentes en tiempo de ejecucion
		Arma espada = FabricaArmas.crear("espada");
		g1.setArma(espada);
		
		g1.atacar();
		
		Guerrero g2 = new Guerrero();
		g2.setNombre("Legolas");
		
		Arma arco = FabricaArmas.crear("arco");
		g2.setArma(arco);
		
		g2.atacar();
		
		//Segunda parte con fábrica de personajes
		
		Personaje p1 = FabricaPersonajes.crear("guerrero");
		p1.setNombre("Anacleto");
		Arma e1 = FabricaArmas.crear("espada");
		p1.setArma(e1);
		p1.atacar();
		
		Personaje p2 = FabricaPersonajes.crear("mago");
		p2.setNombre("Harry Potter");
		Arma e2 = FabricaArmas.crear("hechizoFuego");
		p2.setArma(e2);
		p2.atacar();
		

	}

}
