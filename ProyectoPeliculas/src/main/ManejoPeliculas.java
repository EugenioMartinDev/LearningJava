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
	año de estreno
Del director quiero guardar 2 cosas
 	nombre
	edad
A la hora de listar se mostrarán todos los datos de todas las peliculas que haya dado del alta el usuario
Cuando busquemos una pelicula por titulo deberemos de mostrar toda la información relevante a la pelicula
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
				System.out.println("Introduce el titulo a buscar : ");
				String titulo = sc.next();
				ArrayList<Pelicula> peliculas = buscarPeliculaPorTitulo(titulo, listaPeliculas);
				if (peliculas != null) {
					System.out.println(peliculas);
				}
				else
					System.out.println("No se ha encontrado la película de título " + titulo);
				break;
				
			default:
				System.out.println("Opción errónea");
			
			}
				
			
		} while (opcion != 0);
		
		System.out.println("Aplicación terminada");

		

	}

	private static ArrayList<Pelicula> buscarPeliculaPorTitulo(String titulo, ArrayList<Pelicula> listaPeliculas) {
	
		
		ArrayList<Pelicula> miListaEncontrada = new ArrayList<Pelicula>();
		
		for (Pelicula pelicula : listaPeliculas) {
			
			if (pelicula.getTitulo().contains(titulo))
			{
				miListaEncontrada.add(pelicula);
			}
		}
		
		return miListaEncontrada;
		
	}

	private static void listaPeliculas(ArrayList<Pelicula> listaPeliculas) {

		for (Pelicula pelicula : listaPeliculas) {
			System.out.println(pelicula);
		}
		
	}

	private static void altaPelicula(ArrayList<Pelicula> listaPeliculas) {
		
		Pelicula pelicula = new Pelicula();
		Director director = new Director();
		
		System.out.println("Introduce el título de la película ");
		String titulo = sc.next();
		System.out.println("Introduce el género de la película ");
		String genero = sc.next();
		System.out.println("Introduce el año de la película ");
		int anioEstreno = validarEnteroPorConsola();
		//Integer anioEstreno = Integer.valueOf(sc.next());
		pelicula.setTitulo(titulo);
		pelicula.setGenero(genero);
		pelicula.setAnioEstreno(anioEstreno);
		
		System.out.println("Introduce el nombre del director");
		String nombre = sc.next();		
		System.out.println("Introduce la edad del director");
		int edad = validarEnteroPorConsola();
		director.setNombre(nombre);
		director.setEdad(edad);
		
		pelicula.setDirector(director);

		listaPeliculas.add(pelicula);
		
	}

	private static int mostrarMenu() {
		
		int opcion = -1;
		
		System.out.println("1- Introducir los datos de una película");
		System.out.println("2- Listar todas las películas");
		System.out.println("3- Buscar una película por su título");
		System.out.println("0- Terminar la aplicación");
		
		boolean valido = false;
		while (!valido)
		{
			try {
				String lectura = sc.next();
				opcion = Integer.parseInt(lectura);
				
				if (opcion < 0 || opcion > 3)
				{
					System.out.println("Introduce un entero entre 0 y 3 (0, 1, 2, 3) ");
				}
				else				
					valido = true;
			} catch (Exception ex){
				System.out.println("Introduce un entero");
			}
		}
		
		//opcion = sc.nextInt();
	
		
		return opcion;
	}

	
	public static int validarEnteroPorConsola() {
		
		int valor = 0;
		boolean valido = false;

		while (!valido)
		{
			try {
				String lectura = sc.next();
				valor = Integer.parseInt(lectura);
				valido = true;
			} catch (Exception ex){
				System.out.println("Introduce un entero");
			}
		}
		
		return valor;
		
	}


}
