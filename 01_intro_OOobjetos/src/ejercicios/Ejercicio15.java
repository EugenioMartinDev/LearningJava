package ejercicios;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {

/*
 * 
 * 
 *  1.	Ejecutar las siguientes sentencias
		a.	Leer de consola el nombre y escribirlo en mayúsculas y en minúsculas
		b.	Sacar los tres primeros caracteres de este nombre
		c.	Escribir cuantos caracteres tiene
	2.	Convertir una cadena de caracteres a entero
	3.	Solicitar un numero al azar.

 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un nombre : ");
		String nombre = sc.next();
		
		System.out.println("Nombre en minúsculas " + nombre.toLowerCase() + " y en mayúsculas " + nombre.toUpperCase());
		
		System.out.println("Y los tres primeros caracteres son " + nombre.substring(0, 3));
		
		System.out.println("Y tiene " + nombre.length() + " caracteres");
		
		Integer miEntero = 0;
		System.out.println("Introduce un numero : ");
		String miString = sc.next();
		
		miEntero = Integer.valueOf(miString);
		System.out.println("Valor entero : " + miEntero);
		
		System.out.println("RANDOM " + Math.random());
		
		sc.close();
		
		
		
		
		
	}

}
