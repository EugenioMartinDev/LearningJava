package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.negocio.GestorLibreria;

public class MainLibreria {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Libreria libreria = new Libreria();

		System.out.println("Nombre de la librer�a : ");
		libreria.setNombre(sc.nextLine());

		GestorLibreria gl = new GestorLibreria();
		gl.setLibreria(libreria);

		String opcion = "0";

		do {

			System.out.println("1- Dar de alta un libro");
			System.out.println("2- Listar la libreria " + libreria.getNombre());
			System.out.println("3- Buscar un libro por su ISBN");
			System.out.println("4- Buscar un libro por su editorial");
			System.out.println("0- Terminar la aplicaci�n");

			opcion = sc.nextLine();

			switch (opcion) {

			case "1":

			{
				Libro libro = new Libro();

				System.out.println("Introduce ISBN : ");
				libro.setIsbn(sc.nextLine());
				System.out.println("Introduce T�tulo : ");
				libro.setTitulo(sc.nextLine());
				System.out.println("Introduce Editorial : ");
				libro.setEditorial(sc.nextLine());
				System.out.println("Introduce a�o de publicaci�n : ");
				String sAnioPublicacion = sc.nextLine();
				libro.setAnioPublicacion(Integer.parseInt(sAnioPublicacion));

				if (gl.altaLibro(libro)) {
					System.out.println("Libro aceptado en librer�a " + libreria.getNombre());
				} else
					System.out.println("Libro rechazado en librer�a " + libreria.getNombre());
			}

			break;

			case "2":

				for (Libro elementoLibro : libreria.getListaLibros()) {
					System.out.println(elementoLibro);
				}
				break;

			case "3":

			{
				System.out.println("Introducir ISBN :");
				String isbn = sc.nextLine();
				Libro libro = gl.buscarLibroPorIsbn(isbn);
				if (libro != null) {
					System.out.println(libro);
				} else
					System.out.println("Libro no encontrado");
			}
			break;

			case "4":

				System.out.println("Introducir Editorial : ");
				String editorial = sc.nextLine();
				ArrayList<Libro> listaLibros = gl.buscarLibroPorEditorial(editorial);
				if (listaLibros.size() > 0) {
					for (Libro elementoLibro : listaLibros) {
						System.out.println(elementoLibro);
					}
				} else
					System.out.println("Ning�n libro encontrado para la editorial " + editorial);
				break;

			default:

			}

		} while (!opcion.equals("0"));

		System.out.println("Aplicaci�n terminada");

	}

}
