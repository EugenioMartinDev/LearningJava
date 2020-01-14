package modelo.entidadFelix;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.negocioFelix.GestorPeliculasFelix;
import vistaFelix.DirectorFelix;
import vistaFelix.PeliculaFelix;

public class MainPeliculaFelix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String opcion = "0";		
		GestorPeliculasFelix gpf = new GestorPeliculasFelix();
		ArrayList<PeliculaFelix> listaPeliculas = new ArrayList<PeliculaFelix>();
		gpf.setListaPeliculas(listaPeliculas);
		
		do {
			System.out.println("1- Alta de películas");
			System.out.println("2- Lista de películas");
			System.out.println("3- Buscar película por título");
			System.out.println("4- Buscar película por género");
			opcion = sc.nextLine();
			
			if(opcion.equals("1")) {
				System.out.println("Introduzca el título: ");
				String titulo = sc.nextLine();
				System.out.println("Introduzca el género: ");
				String genero = sc.nextLine();
				System.out.println("Introduzca el nombre del director: ");
				String nombre = sc.nextLine();
				System.out.println("Introduzca la edad: ");
				String sEdad = sc.nextLine();
				System.out.println("Introduzca el año de estreno: ");
				String sAnioEstreno = sc.nextLine();
				
				

				int edad = Integer.parseInt(sEdad);
				int anioEstreno = Integer.parseInt(sAnioEstreno);
				
				DirectorFelix director = new DirectorFelix();
				director.setNombre(nombre);
				director.setEdad(edad);
				
				PeliculaFelix pelicula = new PeliculaFelix();
				pelicula.setGenero(genero);
				pelicula.setAnioEstreno(anioEstreno);
				pelicula.setTitulo(titulo);
				pelicula.setDirector(director);
				
				if (gpf.alta(pelicula)) {
					System.out.println("Película aceptada");
				} else System.out.println("Película rechazada porque el título tiene menos de 5 caracteres");
				
				//las referencias pelicula/director/nombre... desaparecen cuando salimos del bloque, pero no el objeto pelicula y objeto director
				//Si hubieramos definido gpf como new dentro del bloque, lo habríamos perdido todo.
				
			} else if(opcion.equals("2")) {
				ArrayList<PeliculaFelix> peliculas = gpf.getListaPeliculas();
				for (PeliculaFelix pelicula : peliculas) {
					System.out.println(pelicula);
				}
			} else if(opcion.equals("3")) {
				System.out.println("Introduzca el título a buscar");
				String titulo = sc.nextLine();
				PeliculaFelix pelicula = gpf.buscarPorTitulo(titulo);
				if(pelicula == null) {
					System.out.println("La película no se ha encontrado");
				} else {
					System.out.println("Película encontrada : " + pelicula);
				} 
			} else if(opcion.equals("4")) {
				System.out.println("Introduzca el género a buscar");
				String genero = sc.nextLine();
				ArrayList<PeliculaFelix> peliculasGenero = gpf.buscarPorGenero(genero);
				if (peliculasGenero.size() > 0) {
					System.out.println("Lista de películas de género " + genero);
					for (PeliculaFelix pelicula : peliculasGenero) {
						System.out.println(pelicula);
					}
				} else {
					System.out.println("No hay ninguna película de género " + genero);
				}
			}
			
		}while(!opcion.equals("0"));

		System.out.println("Salimos del programa");
	}

}
