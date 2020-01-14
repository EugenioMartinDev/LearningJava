package modelo.entidadFelix;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.negocioFelix.GestorPeliculasFelix;
import vistaFelix.DirectorFelix;
import vistaFelix.PeliculaFelix;

public class SpringMainPeliculaFelix {
	
	public static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = context.getBean("scanner", Scanner.class);
		
		String opcion = "0";		
		//GestorPeliculasFelix gpf = new GestorPeliculasFelix();
		GestorPeliculasFelix gpf = context.getBean("gestorPeliculas", GestorPeliculasFelix.class);
		//ArrayList<PeliculaFelix> listaPeliculas = new ArrayList<PeliculaFelix>();
		//gpf.setListaPeliculas(listaPeliculas);
		
		do {
			System.out.println("1- Alta de pel�culas");
			System.out.println("2- Lista de pel�culas");
			System.out.println("3- Buscar pel�cula por t�tulo");
			System.out.println("4- Buscar pel�cula por g�nero");
			opcion = sc.nextLine();
			
			if(opcion.equals("1")) {
				System.out.println("Introduzca el t�tulo: ");
				String titulo = sc.nextLine();
				System.out.println("Introduzca el g�nero: ");
				String genero = sc.nextLine();
				System.out.println("Introduzca el nombre del director: ");
				String nombre = sc.nextLine();
				System.out.println("Introduzca la edad: ");
				String sEdad = sc.nextLine();
				System.out.println("Introduzca el a�o de estreno: ");
				String sAnioEstreno = sc.nextLine();
				
				

				int edad = Integer.parseInt(sEdad);
				int anioEstreno = Integer.parseInt(sAnioEstreno);
				
				//DirectorFelix director = new DirectorFelix();
				DirectorFelix director = context.getBean("director", DirectorFelix.class);
				director.setNombre(nombre);
				director.setEdad(edad);
				
				//PeliculaFelix pelicula = new PeliculaFelix();
				PeliculaFelix pelicula = context.getBean("pelicula", PeliculaFelix.class);
				pelicula.setGenero(genero);
				pelicula.setAnioEstreno(anioEstreno);
				pelicula.setTitulo(titulo);
				pelicula.setDirector(director);
				
				if (gpf.alta(pelicula)) {
					System.out.println("Pel�cula aceptada");
				} else System.out.println("Pel�cula rechazada porque el t�tulo tiene menos de 5 caracteres");
				
				//las referencias pelicula/director/nombre... desaparecen cuando salimos del bloque, pero no el objeto pelicula y objeto director
				//Si hubieramos definido gpf como new dentro del bloque, lo habr�amos perdido todo.
				
			} else if(opcion.equals("2")) {
				ArrayList<PeliculaFelix> peliculas = gpf.getListaPeliculas();
				for (PeliculaFelix pelicula : peliculas) {
					System.out.println(pelicula);
				}
			} else if(opcion.equals("3")) {
				System.out.println("Introduzca el t�tulo a buscar");
				String titulo = sc.nextLine();
				PeliculaFelix pelicula = gpf.buscarPorTitulo(titulo);
				if(pelicula == null) {
					System.out.println("La pel�cula no se ha encontrado");
				} else {
					System.out.println("Pel�cula encontrada : " + pelicula);
				} 
			} else if(opcion.equals("4")) {
				System.out.println("Introduzca el g�nero a buscar");
				String genero = sc.nextLine();
				ArrayList<PeliculaFelix> peliculasGenero = gpf.buscarPorGenero(genero);
				if (peliculasGenero.size() > 0) {
					System.out.println("Lista de pel�culas de g�nero " + genero);
					for (PeliculaFelix pelicula : peliculasGenero) {
						System.out.println(pelicula);
					}
				} else {
					System.out.println("No hay ninguna pel�cula de g�nero " + genero);
				}
			}
			
		}while(!opcion.equals("0"));

		System.out.println("Salimos del programa");
	}

}
