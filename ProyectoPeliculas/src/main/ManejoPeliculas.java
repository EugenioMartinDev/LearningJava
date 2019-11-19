package main;

import java.util.ArrayList;
import java.util.Scanner;

import entidad.Director;
import entidad.Pelicula;

public class ManejoPeliculas {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		/*
		 * 
		 * Ejercicio Peliculas
Quiero hacer una aplicacion en la que mostremos un menu tal como sigue
1 - Alta Pelicula
2 - Listar pelicula
3 - Buscar Pelicula por titulo
0 - salir el programa

Quiero guardar en un array list todas la peliculas que se vayan dando de alta. 
Que quiero guardar dentro de una pelicula
	titulo
	genero
	director
	a�o de estreno
Del director quiero guardar 2 cosas
 	nombre
	edad
A la hora de listar se mostrar�n todos los datos de todas las peliculas que haya dado del alta el usuario
Cuando busquemos una pelicula por titulo deberemos de mostrar toda la informaci�n relevante a la pelicula
		 * 
		 */
		
		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		
		int opcion = 0;
		
		do {
			
			opcion = mostrarMenu();
			
			switch (opcion) {
			
			case 0:
				//fin
				break;
			
			case 1:
				altaPelicula(listaPeliculas);
				break;
				
			case 2:
				listaPeliculas(listaPeliculas);
				break;
				
			case 3:
				buscarPeliculaPorTitulo(listaPeliculas);
				break;
				
			default:
				System.out.println("Opci�n err�nea");
			
			}
				
			
		} while (opcion != 0);
		
		System.out.println("Aplicaci�n terminada");

		

	}

	private static void buscarPeliculaPorTitulo(ArrayList<Pelicula> listaPeliculas) {
		
		System.out.println("Introduce el titulo a buscar : ");
		String titulo = sc.next();
		
		for (Pelicula pelicula : listaPeliculas) {
			
			if (pelicula.getTitulo().contentEquals(titulo))
			{
				System.out.println("La pel�cula es : " + pelicula);
				return;
			}
		}
		
		System.out.println("Pel�cula de t�tulo " + titulo + " no encontrada");
		
	}

	private static void listaPeliculas(ArrayList<Pelicula> listaPeliculas) {

		for (Pelicula pelicula : listaPeliculas) {
			System.out.println(pelicula);
		}
		
	}

	private static void altaPelicula(ArrayList<Pelicula> listaPeliculas) {
		
		Pelicula pelicula = new Pelicula();
		Director director = new Director();
		
		System.out.println("Introduce el t�tulo de la pel�cula ");
		String titulo = sc.next();
		System.out.println("Introduce el g�nero de la pel�cula ");
		String genero = sc.next();
		System.out.println("Introduce el a�o de la pel�cula ");
		Integer anioEstreno = Integer.valueOf(sc.next());
		pelicula.setTitulo(titulo);
		pelicula.setGenero(genero);
		pelicula.setAnioEstreno(anioEstreno);
		
		System.out.println("Introduce el nombre del director");
		String nombre = sc.next();
		System.out.println("Introduce la edad del director");
		Integer edad = Integer.valueOf(sc.next());
		director.setNombre(nombre);
		director.setEdad(edad);
		
		pelicula.setDirector(director);

		listaPeliculas.add(pelicula);
		
	}

	private static int mostrarMenu() {
		
		int opcion = 0;
		
		System.out.println("1- Introducir los datos de una pel�cula");
		System.out.println("2- Listar todas las pel�culas");
		System.out.println("3- Buscar una pel�cula por su t�tulo");
		System.out.println("0- Terminar la aplicaci�n");
		
		opcion = sc.nextInt();
	
		
		return opcion;
	}



}
