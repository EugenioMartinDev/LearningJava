package ejercicios;
import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		/*
		 * 
		 * 1.	Leer tres números correspondientes a los lados de un triángulo.
				a.	Para que sea un triángulo válido se debe cumplir que la suma de cualquiera de dos lados sea superior al otro. 
					Si no se Escribirá “triangulo no valido” y se para el proceso. Por ejemplo
					o	3, 4 , 5 es válido. 3+4>5; 4+5>3 y 3+5 > 4
					o	2,1,1 : No vale 1+1 no > 2 y no vale
				b.	Una vez que es válido  Escribir si el triángulo es:
					o	 equilátero(3 lados iguales)
					o	Isósceles(2 iguales y uno desigual)
					o	Escaleno ( 3 lados desiguales).

		 */

		Scanner sc = new Scanner(System.in);
		
		double lado1 = 0;
		double lado2 = 0;
		double lado3 = 0;
		
		System.out.println("Introduce el valor del primer lado : ");
		lado1 = sc.nextDouble();
		
		System.out.println("Introduce el valor del segundo lado : ");
		lado2 = sc.nextDouble();
		
		System.out.println("Introduce el valor del tercer lado : ");
		lado3 = sc.nextDouble();
		
		sc.close();
		
		
		if ( ((lado1+lado2) > lado3)
			&& ((lado1+lado3) > lado2)
			&& ((lado2+lado3) > lado1))
		{
			boolean lado1Iguallado2 = false;
			boolean lado1Iguallado3 = false;
			boolean lado2Iguallado3 = false;
			
			if (lado1 == lado2)
				lado1Iguallado2 = true;
			
			if (lado1 == lado3)
				lado1Iguallado3 = true;
			
			if (lado2 == lado3)
				lado2Iguallado3 = true;
			
			if (lado1Iguallado2 && lado1Iguallado3)
				System.out.println("Triángulo equilátero");
			else
				if (lado1Iguallado2 || lado1Iguallado3 || lado2Iguallado3)
					System.out.println("Triángulo isósceles");
				else
					System.out.println("Triángulo escaleno");
			
		}
		else
			System.out.println("Triángulo no válido");
		
	}

}
