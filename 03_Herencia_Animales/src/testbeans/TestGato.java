package testbeans;

import beans.Gato;

public class TestGato {

	public static void main(String[] args) {

		Gato gato1, gato2;
		
		gato1 = new Gato();
		gato2 = new Gato("listado", 7);
		
		System.out.println("gato1 : " + gato1 + " - " + "gato2 : " + gato2);
		
		gato1.sonido();
		gato1.saludo();
		
		gato2.sonido();
		gato2.saludo();

	}

}
