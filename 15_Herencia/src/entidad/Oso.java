package entidad;

public class Oso extends Animal {

	
	
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

}
