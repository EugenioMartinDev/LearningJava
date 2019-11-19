package testbeans;

import beans.Animal;
import beans.Gato;

public class TestZoologico {

	public static void main(String[] args) {

		Animal a1 = new Animal("Camale�n : verde");
		Animal a2 = new Animal("Hipop�tamo : marr�n");

		Gato g1 = new Gato("Gato siam�s : blanco", 7);
		Gato g2 = new Gato("Gato callejero : negro", 6);

		a1.sonido();
		g1.sonido();

		Animal[] zoologico = { a1, a2, g1, g2 };

		for (Animal elemento : zoologico) {
			elemento.sonido();
			System.out.println(elemento);
			if (elemento instanceof Gato) {
				((Gato) elemento).trepar();
			}
		}

	}

}
