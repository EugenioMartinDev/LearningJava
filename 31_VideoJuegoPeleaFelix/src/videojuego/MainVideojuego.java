package videojuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainVideojuego {

	public static void main(String[] args) {
		
		Personaje g1 = FabricaPersonajes.crear("guerrero");
		g1.setNombre("Conan");
		g1.setVida(200);
	
		
		//Gracias a usar abstraciones y patrones (fabrica)
		//podemos crear objetos diferentes en tiempo de ejecucion
		Arma espada = FabricaArmas.crear("espada");
		espada.setDanioMax(25);
		espada.setDanioMin(10);
		espada.setTipo("Espada");
		g1.setArma(espada);
		

		
		Personaje m1 = FabricaPersonajes.crear("mago");
		m1.setNombre("Harry Potter");
		m1.setVida(200);
		
		Arma hechizo = FabricaArmas.crear("hechizoFuego");
		hechizo.setDanioMin(10);
		hechizo.setDanioMax(20);
		hechizo.setTipo("Hechizo De Fuego");
		m1.setArma(hechizo);
		
		//Partida partida = new Partida(g1, m1);
		//partida.empezar();
		
		Personaje e1 = FabricaPersonajes.crear("enano");
		e1.setNombre("Gimli");
		e1.setVida(250);
		
		Arma arco = FabricaArmas.crear("arco");
		arco.setDanioMax(35);
		arco.setDanioMin(5);
		arco.setTipo("compuesto");
		e1.setArma(arco);
		
		List<Personaje> listaLuchadores = new ArrayList<Personaje>();
		listaLuchadores.add(g1);
		listaLuchadores.add(m1);
		listaLuchadores.add(e1);
		
		Coliseo coliseo = new Coliseo(listaLuchadores);
		
		Map<String,Integer> victorias = new HashMap<String,Integer>();
		victorias.put("Conan",0);
		victorias.put("Harry Potter",0);
		victorias.put("Gimli",0);
				
		for (int i=0; i<10000; i++) {
			g1.setVida(200);
			m1.setVida(200);
			e1.setVida(250);
			listaLuchadores.clear();
			listaLuchadores.add(g1);
			listaLuchadores.add(m1);
			listaLuchadores.add(e1);
			coliseo.setLuchadores(listaLuchadores);
			
			coliseo.empezar(victorias);
			
		}
		
		
		System.out.println("Victorias de Conan : " + victorias.get("Conan"));
		System.out.println("Victorias de Harry Potter : " + victorias.get("Harry Potter"));
		System.out.println("Victorias de Gimli : " + victorias.get("Gimli"));
		
		//coliseo.empezar();
		
	}

}
