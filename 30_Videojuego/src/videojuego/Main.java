package videojuego;

public class Main {

	public static void main(String[] args) {

		Guerrero guerrero = new Guerrero();
		guerrero.setNombre("Connan");
		guerrero.setPotencia(Math.random()*300);
		
		// Por las abstracciones y patrones factory se pueden crear objetos diferentes en tiempo de EJECUCIÓN.
		Arma espada = FabricaDeArmas.create(args[0]);
		guerrero.setArma(espada);		
		//guerrero.atacar();
		
		Guerrero guerrero2 = new Guerrero();
		guerrero2.setNombre(args[1]);
		Arma arco = FabricaDeArmas.create(args[2]);
		guerrero2.setArma(arco);		
		//guerrero2.atacar();
		
		Personaje mago1 = FabricaDePersonajes.create(args[3]);
		mago1.setNombre(args[4]);
		Arma hechizo1 = FabricaDeArmas.create(args[5]);
		hechizo1.setTipo(args[6]);
		mago1.setArma(hechizo1);
		//mago1.atacar();
		
		Personaje enano1 = FabricaDePersonajes.create(args[7]);
		enano1.setNombre(args[8]);
		Arma broma1 = FabricaDeArmas.create(args[9]);
		broma1.setTipo(args[10]);
		enano1.setArma(broma1);
		//enano1.atacar();
		
		int contadorBatallas = 0 ;
		System.out.println("**************** COMIENZO DE BATALLAS **********************");
		System.out.println("!!!!!!!!!! BATALLA " + contadorBatallas++);
		if (finBatalla(guerrero2, guerrero)) return;
		System.out.println("!!!!!!!!!! BATALLA " + contadorBatallas++);
		if (finBatalla(mago1, guerrero)) return;
		System.out.println("!!!!!!!!!! BATALLA " + contadorBatallas++);
		if (finBatalla(enano1, guerrero)) return;		
		System.out.println("**************** FIN DE BATALLAS **********************");
		System.out.print("Nadie ha podido con " + guerrero.getNombre());
		System.out.println(" que se ha quedado con " + guerrero.getPotencia());	
	}

	private static boolean finBatalla(Personaje desafiante, Personaje desafiado) {		
		System.out.println(" Potencia de " +  desafiado.getNombre() + " " + desafiado.getPotencia());
		System.out.println(desafiante.getNombre() + " lucha con " + desafiante.getArma().getTipo() + " de valor " + desafiante.getArma().getValor());
		boolean resultado = desafiante.lucha(desafiado);
		System.out.println( desafiado.getNombre() + " se ha quedado con " + desafiado.getPotencia());
		if (resultado) {
			System.out.print(desafiante.getNombre() + " ha vencido a " + desafiado.getNombre());
			System.out.println(" que se ha quedado con " + desafiado.getPotencia());
		}
		return resultado;
	}
	
	

}
