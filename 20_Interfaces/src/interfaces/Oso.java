package interfaces;

//En Animal ya implementamos la interfaz Movible.
//En Oso no haría falta incluir "implements Movible", aunque hay que 
//implementar los métodos abstratos de la interfaz

//Se puede implementar la interfaz movible en Oso o en Animal (aquí sobraría entonces).
public class Oso extends Animal implements Movible {

	@Override
	public void comer(Object comida) {
		if (comida instanceof Animal) {
			Animal a = (Animal)comida;
			System.out.println("Soy un oso que me llamo " + nombre 
					+ " y me voy a comer un animal " + a.getClass().getSimpleName()
					+ " y de nombre " + a.nombre);
		} else {
			System.out.println("Los osos solo comemos animales");
		}

	}

	@Override
	public void moverseLento() {
		System.out.println("Soy un oso y me muevo 5 metros");
		
	}

	@Override
	public void moverse(int metros) {
		System.out.println("Soy un oso y me muevo " + metros + " metros ");
		
	}

}
