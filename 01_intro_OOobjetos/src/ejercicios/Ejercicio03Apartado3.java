package ejercicios;

public class Ejercicio03Apartado3 {

	
	public static void main(String[] args) {
		
		/*
		 *  1.- Declarar variables.
		 *  2.- Obtener los datos de entrada
		 *  3.- Procesar los datos de entrada - Generar salida parcial y/o total
		 *  4.- Escribir estadísticas
		 */
	
		int l1 = 0;
		int l2 = 0;
		
		//reading simulation
		l1 = 3;
		l2 = 4;
		
		System.out.println("Lados del rectángulo = " + l1 + " y " + l2);
		System.out.println("Perímetro = " + (2 * (l1 + l2)));
		System.out.println("Área = " + (l1 * l2));
		System.out.println("Hipotenusa = " + Math.sqrt(Math.pow(l1, 2)+Math.pow(l2, 2)));

		
		int lado1 = 0;
		int lado2 = 0;
		int perimetro = 0; 
		int area = 0;
		double hipotenusa = 0;
		
		lado1 = 7; 
		lado2 = 4;
		
		perimetro = 2 * (lado1 + lado2);
		area = lado1 * lado2;
		hipotenusa = Math.sqrt(Math.pow(lado1, 2)+Math.pow(lado2, 2));
		
		System.out.println("Lados = " + lado1 + " y " + lado2 + " ==>  perímetro = " + perimetro + " área = " + area + " hipotenusa = " + hipotenusa);

	}

}
