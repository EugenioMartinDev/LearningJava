package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.negocio.GestorLibreria;

public class MainLibreria {

	public static void main(String[] args) {
		
		//Primera parte
		//Creaci�n de los objetos necesarios para el programa 
		//y la inyecci�n de sus dependencias.
		Scanner sc = new Scanner(System.in);
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();		
		System.out.println("Introduzca el nombre de la librer�a : ");
		String nombreLibreria = sc.nextLine();
		Libreria libreria = new Libreria();
		libreria.setNombre(nombreLibreria);
		libreria.setListaLibros(listaLibros);
		
		GestorLibreria gl = new GestorLibreria(libreria);
		
		String opcion = "0";
		
		do {
			System.out.println("************ Libreria " + libreria.getNombre());
			System.out.println("1- Alta de libro");
			System.out.println("2- Lista de libro");
			System.out.println("3- Buscar libro por isbn");
			System.out.println("4- Buscar libros por editorial");
			System.out.println("0- Terminar el programa");
			opcion = sc.nextLine();
			
			if (opcion.equals("1")) {
				Libro libro = new Libro();
				System.out.println("Titulo");
				libro.setTitulo(sc.nextLine());
				System.out.println("ISBN");
				libro.setIsbn(sc.nextLine());
				System.out.println("editorial");
				libro.setEditorial(sc.nextLine());
				System.out.println("a�o de publicacion");
				libro.setAnioPublicacion(Integer.parseInt(sc.nextLine()));
				
				int alta = gl.alta(libro);
				if (alta == 1) System.out.println("El libro necesita isbn");
				if (alta == 2) System.out.println("El libro necesita t�tulo");
				if (alta == 3) System.out.println("Ya existe un libro con el mismo isbn");
				if (alta == 0) System.out.println("Libro actualizado en la libreria");
			} else if (opcion.equals("2")) {
				ArrayList<Libro> libros = gl.getLibreria().getListaLibros();
				if (libros.size() == 0) {
					System.out.println("No existe ning�n libro");
				} else {
					for (Libro libro : libros) {
						System.out.println(libro);
					}
				}
			} else if (opcion.equals("3")) {
				System.out.println("Introduce el ISBN a buscar");
				Libro libro = gl.buscarPorIsbn(sc.nextLine());
				if (libro == null) {
					System.out.println("Libro no encontrado");
				}
				else
					System.out.println(libro);
			} else if (opcion.equals("4")) {
				System.out.println("Introduce editorial para buscar sus libros");
				ArrayList<Libro> lista = gl.buscarPorEditorial(sc.nextLine());
				if (lista.size() != 0) {
					for (Libro libro : lista) {
						System.out.println(libro);
					}
				} else {
					System.out.println("No se ha encontrado ning�n libro para la editorial");
				}
			}	
			
		} while (!opcion.equals("0"));
		
		
		System.out.println("Aplicaci�n terminada");
		sc.close();
	}

}
