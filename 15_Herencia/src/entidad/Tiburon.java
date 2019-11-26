package entidad;

public class Tiburon extends Pez {

	// En "source", seleccionar override/implement Methods ...
	// y elegir comer.
	// super posiciona al padre : podemos borrarlo 
	// y crear una función nueva o dejarlo y añadir nueva funcionalidad 
	@Override
	public void comer(Object comida) {
		//super.comer(comida);
		
		if (comida instanceof Pez) {  // Se puede preguntar que la instancia sea una clase abstracta (Trucha o PezPayaso)
			Pez pez = (Pez) comida;
			System.out.println("Soy el tiburón " + nombre + " y me voy a comer el pez de tipo " 
		                       +  pez.getClass().getSimpleName() + " y de nombre " + pez.nombre);
		} else {
			System.out.println("Soy un tiburón asesino y solo como peces");
		}
	}
	
}
