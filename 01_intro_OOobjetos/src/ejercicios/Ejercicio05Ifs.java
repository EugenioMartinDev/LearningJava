package ejercicios;
import java.util.Scanner;

public class Ejercicio05Ifs {

	public static void main(String[] args) {
		
		
		/*
		 *  1.- Declarar variables.
		 *  2.- Obtener los datos de entrada
		 *  3.- Procesar los datos de entrada - Generar salida parcial y/o total
		 *  4.- Escribir estadísticas
		 */
		
		/*
		int radio = 0;
		
		System.out.println("Introduce el radio : ");
		
		Scanner myInput = new Scanner(System.in);
		radio = myInput.nextInt();

		if (radio == 4)
			System.out.println("es 4");
		else 
		{
			System.out.println("no es 4");
			if (radio < 4)
			{
				System.out.println("menor de 4");
				radio = 5;
			} else System.out.println("mayor de 4");
			
		}
		System.out.println("radio : " + radio);
		*/	
		
		int mes = 0;
		
		String[] nombreMes = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
		
		System.out.println("Introduce el mes : ");
		
		Scanner myInput = new Scanner(System.in);
		mes = myInput.nextInt();
		
		switch(mes) {
		
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				System.out.println("El mes " + mes + " " + nombreMes[mes-1] + " es de 31 días");
				break;
			case 4: case 6: case 9: case 11:
				System.out.println("El mes " + mes + " " + nombreMes[mes-1] + " es de 30 días");
				break;
			case 2:
				System.out.println("El mes " + mes + " " + nombreMes[mes-1] + " es de 28 o 29 días");
				break;
			default:
				System.out.println("Error en el número del mes");
		
		
		}
		
		
		myInput.close();
		
				
		/*
		switch (radio)
		{
		
		case 2:
			System.out.println("Resultado para valor 2 : Circunferencia = " + 2*Math.PI*radio + " |||| Área = "+ Math.PI * Math.pow(radio,2));
			break;
			
		case 3:
			System.out.println("Resultado para valor 3 : Circunferencia = " + 3*Math.PI*radio + " |||| Área = "+ Math.PI * Math.pow(radio,3));
			break;
			
		default:
			System.out.println("Resultado para un valor distinto de 2 y 3 : Circunferencia = " + 1*Math.PI*radio + " |||| Área = "+ Math.PI * Math.pow(radio,1));
		
		}
		*/
		myInput.close();
		

	}

}
