package ejercicios;

public class Ejercicio16ExplicacionArrays {
	
	public static void pruebaArrayVacio() {
		
		String[] cadenas = new String[6];
		cadenas[0] = "pepe";
		cadenas[1] = "pepe1";
		cadenas[2] = "pepe2";
		cadenas[3] = "pepe3";
		cadenas[4] = "pepe4";
		cadenas[5] = "pepe5";
		
		int[] numeros = new int[7];

		
		for (String elemento : cadenas) {
			if (elemento != null)
			System.out.println(elemento.toUpperCase());
		}
		
		for (int i=0; i<numeros.length; i++)
			numeros[i] = (int) (Math.random()*50+1);
		
		for (int elemento : numeros) {
			System.out.println(elemento);
		}
		
		
	}

	public static void main(String[] args) {
		
		int paresa[], nones;
		
		int paresa2[] = {1,2,3,4};
		
		paresa = new int[5];
		
		nones = 5;
		
		

		int[] pares = {2,6,8,10,34,68};
				
		String[] nombre = {"Andrés", "Esteban", "Zacarías","Eva","Ana", "Sara"};
	
		System.out.println("Longitud de pares : " + pares.length + " Longitud de nombre : " + nombre.length);
		
		for (int i=0; i < pares.length; i++) {
			System.out.print(" Posición " + i + " con valor " + pares[i]);
		}
		
		System.out.println();
		for (String elemento : nombre) {
			System.out.println("Me llamo " + elemento);
			elemento.toUpperCase();
		}		
		
		String cadena = "Tomás;Andrés;Esteba;Ana;Sara";
		for (String elemento : cadena.split(";"))
		System.out.println(elemento);
		
		int[] pares2 = new int[10];
		
		pruebaArrayVacio();

			
	}

}
