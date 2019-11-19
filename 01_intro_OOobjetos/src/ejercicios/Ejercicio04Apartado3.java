package ejercicios;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio04Apartado3 {

	public static void main(String[] args) {
		
		/*
		 *  1.- Declarar variables.
		 *  2.- Obtener los datos de entrada
		 *  3.- Procesar los datos de entrada - Generar salida parcial y/o total
		 *  4.- Escribir estadísticas
		 */
		
		Locale myLocale = Locale.getDefault();
		
		System.out.println(myLocale.toString());

		Locale.setDefault(Locale.UK);
		
		System.out.println(Locale.getDefault().toString());
			
		double radio = 0;
		
		System.out.print("Introduce el valor del radio = ");				
		Scanner leer = new Scanner(System.in);	
		radio = leer.nextDouble();	
		System.out.println();				
		//leer.close();
		
		System.out.println("Resultado : Circunferencia = " + 2*Math.PI*radio + " |||| Área = "+ Math.PI * Math.pow(radio,2));

		Locale.setDefault(myLocale);
		
		System.out.println(Locale.getDefault().toString());
		
		System.out.print("Introduce el valor del radio otra vez = ");
		Scanner leer2 = new Scanner(System.in);
		if (leer2.hasNextDouble())
		{
			radio = leer2.nextDouble();
			System.out.println("Resultado : Circunferencia = " + 2*Math.PI*radio + " |||| Área = "+ Math.PI * Math.pow(radio,2));
		}
		else
		{
			System.out.print("No hay más ");
		}
		leer2.close();
		
	}

}
