package ejercicios;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio13 {
	
	final static double NIVEL1SUELDO = 15000;
	final static double NIVEL2SUELDO = 30000;
	final static double NIVEL3SUELDO = 45000;
	
	final static double NIVEL1COMISION = 2000;
	final static double NIVEL2COMISION = 10000;
	
	final static double SUBIDA12 = 0.12;
	final static double SUBIDA10 = 0.1;
	final static double SUBIDA8 = 0.08;
	final static double SUBIDA6 = 0.06;
	final static double SUBIDA4 = 0.04;

	
	private static double verSalario(double salario)
	{
		double subir = 0;
		
		if (salario <= NIVEL1SUELDO)
		{
			subir = SUBIDA10;
			System.out.println("Se aplica subida del " + (int) (subir*100) + "%. El nuevo sueldo es : " + (salario+(salario*subir)));
		}
		else
			if (salario <= NIVEL2SUELDO)
			{
				subir = SUBIDA8;
				System.out.println("Se aplica subida del " + (int) (subir*100) + "%. El nuevo sueldo es : " + (salario+(salario*subir)));			
			}
			else
				if (salario <= NIVEL3SUELDO)
				{
					subir = SUBIDA4;
					System.out.println("Se aplica subida del " + (int) (subir*100) + "%. El nuevo sueldo es : " + (salario+(salario*subir)));					
				}						
				else
					System.out.println("No se aplica subida");
		return subir;
	}
	
	private static double verComision(double salario, double comitive)
	{
		double subir = 0;

		if (comitive <= NIVEL1COMISION)
		{
			subir = SUBIDA12;
			System.out.println("Se aplica subida del " + (int) (subir*100) + "%. El nuevo sueldo es : " + (salario+(salario*subir)));
		}
		else
			if (comitive <= NIVEL2COMISION)
			{
				subir = SUBIDA6;
				System.out.println("Se aplica subida del " + (int) (subir*100) + "%. El nuevo sueldo es : " + (salario+(salario*subir)));				
			}
			else					
				System.out.println("No se aplica subida");
		return subir;
	}
	
	
	
	

	public static void main(String[] args) {
		/*
		 * 2.	En recursos humanos van a aplicar una política de aumento de sueldo, con arreglo a la siguiente regla. 
		 *      Solicitamos por consola el sueldo y la comisión(ambos numéricos) y:
				a.	Si la comisión es cero, nos fijamos en el sueldo y
						o	Sueldo  menor de 15000, aplicamos un 10% de subida
						o	Sueldo entre 15001 y 30000 aplicamos un 8% subida
						o	Sueldo entre 30001 y 45000 aplicamos un 4% subida
						o	Por encima de 45000, no hay subida
				b.	Si la comisión es > 0, nos fijamos en la comisión y
						o	Si es menor de 2000 aumentamos el sueldo un 12%
						o	Si está comprendido entre 2001 y 10000 aumentamos el sueldo un 6%
						o	Si es mayor no le aumentamos nada.
				c.	Informamos al final de
						o	Cuanto ganaba al principio,
						o	qué % de subida le corresponde
						o	cuanto supone el aumento (cero si no es nada)
						o	En cuanto se le queda el sueldo.

		 * 
		 * 
		 */
		
		double sueldo = 0;
		double comision = 0;
		double subida = 0;
		
		Locale.setDefault(Locale.UK);
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Introduce el sueldo");
		sueldo = sc.nextDouble();

		System.out.println("Introduce la comisión");
		comision = sc.nextDouble();
		
		sc.close();
		
		if (comision == 0)
		{
			subida = verSalario(sueldo);
		}
		else
		{
			subida = verComision(sueldo, comision);

		}
		
		System.out.println("El sueldo inicial es de " + sueldo + " y le corresponde una subida de " 
						+ (subida)*100 + " por ciento. " + "Nuevo sueldo : " + (sueldo+sueldo*subida));
		
	}
	

}
