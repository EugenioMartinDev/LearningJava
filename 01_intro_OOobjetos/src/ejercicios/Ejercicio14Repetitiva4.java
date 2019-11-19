package ejercicios;

public class Ejercicio14Repetitiva4 {

	public static void main(String[] args) {
		
		/*
		 * 4.	Leer 10 números al azar, ente 1 y 50 (y almacenarlos en un arreglo- ahora no). Leer cada uno, escribirlos y al final del proceso Escribir:
				a.	Cuál es la media de los números leídos.
				b.	Cuál es la suma de los números leídos.
				c.	Cuantos son pares y cuantos son impares.

		 * 
		 */
		
		final int LIMITE = 100;
		
		int numero50 = 0;
		int suma = 0;
		int par = 0;
		double media = 0;
		
		System.out.println("Números obtenidos : ");
		for (int i=1; i<=LIMITE; i++) {
			numero50 = (int) ((Math.random()+1)*50);
			System.out.print(numero50 + " ");
			suma += numero50;			
			if (numero50%2 == 0)
				par++;			
		}
		System.out.println();
		
		media = (double) suma/LIMITE;
		
		System.out.println("La media es : " + media + " y la suma es : " + suma + " y pares son : " + par);
		
		
		
	}

}
