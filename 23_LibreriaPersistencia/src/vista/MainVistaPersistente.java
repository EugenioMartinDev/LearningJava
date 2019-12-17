package vista;


import java.util.List;
import java.util.Scanner;


import modelo.entidad.Libro;
import modelo.negocio.GestorLibreriaPersistente;
import modelo.persistencia.DaoLibreria;
import utils.Constantes;

public class MainVistaPersistente {
	
	public static void main(String[] args) {
		
		//Primera parte
		//Creación de los objetos necesarios para el programa 
		//y la inyección de sus dependencias.
		Scanner sc = new Scanner(System.in);
		
		GestorLibreriaPersistente gl = new GestorLibreriaPersistente();
		DaoLibreria daoLibreria = new DaoLibreria();
		gl.setDaoLibreria(daoLibreria);
		
		String opcion = "0";
		
		do {
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
				System.out.println("año de publicacion");
				libro.setAnioPublicacion(Integer.parseInt(sc.nextLine()));
				
				int alta = gl.alta(libro);
				if (alta == Constantes.ERROR_ISBN_IS_NULL) System.out.println("El libro necesita isbn");
				if (alta == Constantes.ERROR_TITLE_IS_NULL) System.out.println("El libro necesita título");
				if (alta == Constantes.ERROR_TITLE_IS_DUPLICATED) System.out.println("Ya existe un libro con el mismo isbn");
				if (alta == Constantes.ERROR_IN_DDBB) System.out.println("Ha fallado la base de datos");
				if (alta == Constantes.SUCCESSFULL_EXECUTION) System.out.println("Libro actualizado en la libreria");
			} else if (opcion.equals("2")) {
				List<Libro> libros = gl.lista();
				if (libros.size() == 0) {
					System.out.println("No existe ningún libro");
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
				List<Libro> lista = gl.buscarPorEditorial(sc.nextLine());
				if (lista.size() != 0) {
					for (Libro libro : lista) {
						System.out.println(libro);
					}
				} else {
					System.out.println("No se ha encontrado ningún libro para la editorial");
				}
			}	
			
		} while (!opcion.equals("0"));
		
		
		System.out.println("Aplicación terminada");
		sc.close();
	}


}
