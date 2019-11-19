package ejercicios;
import java.util.Scanner;

public class Ejercicio14Repetitiva5 {

	public static void main(String[] args) {
		
		/*
		 * 
		 * 5.	Leer de consola nombres de personas, hasta que me teclean la palabra “FIN”. 
		 * Al final del proceso indicar, cuantas palabras tienen un número impar de caracteres, 
		 * cuantas un número par, 
		 * y cuantas palabras hemos leído válidas.
		 */
		
		final String FIN = "FIN";

		Scanner sc = new Scanner(System.in);
		
		String nombre = "";
		int par = 0;
		int impar = 0;
		int contaNombre = 0;
		

		System.out.println("Introduce el nombre : ");
		nombre = sc.next();
		while (!nombre.toUpperCase().equals(FIN)) {
			contaNombre ++;
			if (nombre.length()%2 == 0)
				par++;
			else
				impar++;

			System.out.println("Introduce el nombre : ");
			nombre = sc.next();
			
			
		}
		
		sc.close();
		
		System.out.println("Palabras leídas : " + contaNombre + " palabras pares : " + par + " palabras impares : " + impar);
		
	}

}
