package ejercicios;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		
		/*
		 * 7.	Leemos un n�mero y si es:
				a.	1: Escribimos �uno�
				b.	2: escribimos �dos�
				c.	3: escribimos �Tres�
				d.	Cualquier otro n�mero, escribimos �Otro n�mero�

		 */

		int numero = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un n�mero entero : ");
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
			System.out.println("Otro n�mero");
		
		}
		
		sc.close();
	}

}
