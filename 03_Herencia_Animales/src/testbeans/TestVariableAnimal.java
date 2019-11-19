package testbeans;

import beans.Animal;
import beans.Gato;

public class TestVariableAnimal {
	
	public static Animal findAnimal() {
		
		return new Gato("Gato callejero - negro", 4);
	}
	
	public static Object readObject() {
		
		return new String("Vaya tela");
		
	}

	public static void main(String[] args) {
		
		Animal a1, a2, a3, a4, a5;
		
		a1 = new Animal("Pulpo - rojo");
		a2 = new Gato("Gato Montés - marrón" , 5);
		a3 = new Animal("Camaleón - verde");
		a4 = new Gato("Gato gatuno", 2);
		
		a4.saludo();
		a4.sonido();
		a4.getColor();
		
		((Gato) a4).trepar();
		
		a5 = findAnimal();
		System.out.println(a5);
		
		Gato a6 = (Gato) findAnimal();
		System.out.println(a6);
		
		String prueba = (String) readObject();
		System.out.println(prueba);

		// Exception ClassCastException
		//Object O1; 
		//O1 = (String) readObject();
		//System.out.println((Gato) O1);
		
	}

}
