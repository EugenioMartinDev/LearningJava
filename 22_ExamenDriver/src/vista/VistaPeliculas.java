package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;

public class VistaPeliculas {

	private Scanner sc;	
	private GestorPelicula gp;
	
	public void mostrarApp(GestorPelicula gp, Scanner sc) {		
		this.gp = gp;  //INYECCIÓN DE DEPENDENCIAS
		this.sc = sc;
				
		String opcion = "0";
		
		do {
			System.out.println("1- Alta de película");
			System.out.println("2- Modificación de película");
			System.out.println("3- Borrar película");
			System.out.println("4- Buscar película por id");
			System.out.println("5- Listar películas");
			System.out.println("0- Salir");
			opcion = sc.nextLine();
			
			if (opcion.equals("1")) {
				System.out.println("Introduzca la película a dar de alta");
				Pelicula pelicula = new Pelicula();
				System.out.println("Título");
				pelicula.setTitulo(sc.nextLine());
				System.out.println("Director");
				pelicula.setDirector(sc.nextLine());
				System.out.println("Género");
				pelicula.setGenero(sc.nextLine());
				System.out.println("año de publicacion");
				pelicula.setAnio(Integer.parseInt(sc.nextLine()));
				
				int alta = gp.alta(pelicula);
				if (alta == 1) System.out.println("Algún campo está vacío");
				if (alta == 2) System.out.println("Hay dos películas con el mismo título");
				if (alta == 3) System.out.println("Error de inserción en la base de datos");
				if (alta == 0) System.out.println("Película actualizada en la base de datos");
			} else if (opcion.equals("2")) {
				System.out.println("Introduzca la película a modificar");
				Pelicula pelicula = new Pelicula();
				System.out.println("Título");
				pelicula.setTitulo(sc.nextLine());
				System.out.println("Director");
				pelicula.setDirector(sc.nextLine());
				System.out.println("Género");
				pelicula.setGenero(sc.nextLine());
				System.out.println("año de publicacion");
				pelicula.setAnio(Integer.parseInt(sc.nextLine()));
				System.out.println("Identidad de la película");
				pelicula.setId(Integer.parseInt(sc.nextLine()));
				
				int modificar = gp.modificar(pelicula);
				
				if (modificar == 1) System.out.println("Algún campo está vacío");
				if (modificar == 2) System.out.println("Hay dos películas con el mismo título");
				if (modificar == 3) System.out.println("Error de modificación en la base de datos");
				if (modificar == 0) System.out.println("Película modificada en la base de datos");

			} else if (opcion.equals("3")) {
				System.out.println("Introduzca el id de la película a borrar");
				int id = Integer.parseInt(sc.nextLine());
				
				boolean borrar = gp.borrar(id);
				if (borrar) System.out.println("Película borrada");
				else System.out.println("Se ha producido un error en la base datos");

			} else if (opcion.equals("4")) {
				System.out.println("Introduzca el id de la película a buscar");
				int id = Integer.parseInt(sc.nextLine());
				
				Pelicula pelicula = gp.obtener(id);
				if (pelicula == null) System.out.println("No se ha encontrado la película");
				else System.out.println(pelicula);
			} else if (opcion.equals("5")) {
				List<Pelicula> listaPeliculas = gp.listar();
				
				if (listaPeliculas.size() > 0) {
					for (Pelicula pelicula : listaPeliculas) {
						System.out.println(pelicula);
					}
					
				} else
					System.out.println("No se han encontrado ninguna película");
				System.out.println("Introduzca el id de la película a buscar");
			}
			
		} while (!opcion.equals("0"));
		
		
		System.out.println("Aplicación terminada");
		sc.close();
	}

}
