package ejercicios;
import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		/*
		 * 
		 * 1.	Leer tres n�meros correspondientes a los lados de un tri�ngulo.
				a.	Para que sea un tri�ngulo v�lido se debe cumplir que la suma de cualquiera de dos lados sea superior al otro. 
					Si no se Escribir� �triangulo no valido� y se para el proceso. Por ejemplo
					o	3, 4 , 5 es v�lido. 3+4>5; 4+5>3 y 3+5 > 4
					o	2,1,1 : No vale 1+1 no > 2 y no vale
				b.	Una vez que es v�lido  Escribir si el tri�ngulo es:
					o	 equil�tero(3 lados iguales)
					o	Is�sceles(2 iguales y uno desigual)
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
				System.out.println("Tri�ngulo equil�tero");
			else
				if (lado1Iguallado2 || lado1Iguallado3 || lado2Iguallado3)
					System.out.println("Tri�ngulo is�sceles");
				else
					System.out.println("Tri�ngulo escaleno");
			
		}
		else
			System.out.println("Tri�ngulo no v�lido");
		
	}

}
