package ejercicios;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		
		/*
		 * 7.	Leemos un número y si es:
				a.	1: Escribimos “uno”
				b.	2: escribimos “dos”
				c.	3: escribimos “Tres”
				d.	Cualquier otro número, escribimos “Otro número”

		 */

		int numero = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un número entero : ");
		numero = sc.nextInt();
		
		switch(numero) {		
		case 1:
			System.out.println("uno");
			break;
		case 2:
			System.out.println("dos");
			break;
		case 3:
			System.out.println("tres");
			break;
		default:
			System.out.println("Otro número");
		
		}
		
		sc.close();
	}

}
