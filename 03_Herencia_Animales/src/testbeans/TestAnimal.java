package testbeans;

import beans.Animal;
import beans.Gato;

public class TestAnimal {

	public static void main(String[] args) {

		Animal animalPrueba = new Animal("verde");
		animalPrueba.saludo();
		animalPrueba.sonido();

		
		System.out.println(animalPrueba);
		
		Gato gatoPrueba = new Gato();
		gatoPrueba.trepar();
		gatoPrueba.setColor("marron");		
		
		
		System.out.println(gatoPrueba.getColor());
		
		Animal a1,a2,a3;
		
		a1 = new Animal("negro");
		a2 = new Animal("blanco");
		a3 = new Animal("amarillo");
		
		Animal[] zoologico = {a1, a2, a3};
		
		for (Animal elemento : zoologico) {
			System.out.print("soy " + elemento.getColor().toString() + " y ");
			elemento.sonido();
			System.out.println();
		}
		
	}

}
