package ejercicios;
import java.rmi.registry.LocateRegistry;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		
		/*
		 * 8.	Leer dos n�meros y una palabra, y si  la palabra es:
				a.	Sumar:  escribimos el resultado de sumar  los dos n�meros
				b.	Restar: la resta
				c.	Multiplicar: el producto
				d.	Dividir: la divisi�n
				e.	Resto: el resto de dividir uno entre otro
				f.	Cualquier otra palabra, Escribimos opci�n err�nea
		*
		 */

		
		Locale.setDefault(Locale.UK);
		

		Scanner sc = new Scanner(System.in);
		
		double operador1 = 0;
		double operador2 = 0;
		String operacion = "";
		
		System.out.println("Introduce el primer operador : ");
		operador1 = sc.nextDouble();
		
		System.out.println("Introduce el segundo operador : ");
		operador2 = sc.nextDouble();
		
		System.out.println("Introduce la operaci�n (Sumar/Restar/Multiplicar/Dividir/Resto) : ");
		operacion = sc.next();
		
		switch(operacion) {
		
		case "Sumar":
			System.out.println(operador1 + " + " + operador2 + " = " + (operador1+operador2));
			break;
			
		case "Restar":
			System.out.println(operador1 + " - " + operador2 + " = " + (operador1-operador2));
			break;
			
		case "Multiplicar":
			System.out.println(operador1 + " * " + operador2 + " = " + (operador1*operador2));
			break;
			
		case "Dividir":
			System.out.println(operador1 + " / " + operador2 + " = " + (operador1/operador2));
			break;
			
		case "Resto":
			System.out.println(operador1 + " % " + operador2 + " = " + (operador1%operador2));
			break;
			
		default:
			System.out.println("La operaci�n introducida es err�nea");

		}
		
		sc.close();
		
	}

}
