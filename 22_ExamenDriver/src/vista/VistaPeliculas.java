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
		this.gp = gp;  //INYECCI�N DE DEPENDENCIAS
		this.sc = sc;
				
		String opcion = "0";
		
		do {
			System.out.println("1- Alta de pel�cula");
			System.out.println("2- Modificaci�n de pel�cula");
			System.out.println("3- Borrar pel�cula");
			System.out.println("4- Buscar pel�cula por id");
			System.out.println("5- Listar pel�culas");
			System.out.println("0- Salir");
			opcion = sc.nextLine();
			
			if (opcion.equals("1")) {
				System.out.println("Introduzca la pel�cula a dar de alta");
				Pelicula pelicula = new Pelicula();
				System.out.println("T�tulo");
				pelicula.setTitulo(sc.nextLine());
				System.out.println("Director");
				pelicula.setDirector(sc.nextLine());
				System.out.println("G�nero");
				pelicula.setGenero(sc.nextLine());
				System.out.println("a�o de publicacion");
				pelicula.setAnio(Integer.parseInt(sc.nextLine()));
				
				int alta = gp.alta(pelicula);
				if (alta == 1) System.out.println("Alg�n campo est� vac�o");
				if (alta == 2) System.out.println("Hay dos pel�culas con el mismo t�tulo");
				if (alta == 3) System.out.println("Error de inserci�n en la base de datos");
				if (alta == 0) System.out.println("Pel�cula actualizada en la base de datos");
			} else if (opcion.equals("2")) {
				System.out.println("Introduzca la pel�cula a modificar");
				Pelicula pelicula = new Pelicula();
				System.out.println("T�tulo");
				pelicula.setTitulo(sc.nextLine());
				System.out.println("Director");
				pelicula.setDirector(sc.nextLine());
				System.out.println("G�nero");
				pelicula.setGenero(sc.nextLine());
				System.out.println("a�o de publicacion");
				pelicula.setAnio(Integer.parseInt(sc.nextLine()));
				System.out.println("Identidad de la pel�cula");
				pelicula.setId(Integer.parseInt(sc.nextLine()));
				
				int modificar = gp.modificar(pelicula);
				
				if (modificar == 1) System.out.println("Alg�n campo est� vac�o");
				if (modificar == 2) System.out.println("Hay dos pel�culas con el mismo t�tulo");
				if (modificar == 3) System.out.println("Error de modificaci�n en la base de datos");
				if (modificar == 0) System.out.println("Pel�cula modificada en la base de datos");

			} else if (opcion.equals("3")) {
				System.out.println("Introduzca el id de la pel�cula a borrar");
				int id = Integer.parseInt(sc.nextLine());
				
				boolean borrar = gp.borrar(id);
				if (borrar) System.out.println("Pel�cula borrada");
				else System.out.println("Se ha producido un error en la base datos");

			} else if (opcion.equals("4")) {
				System.out.println("Introduzca el id de la pel�cula a buscar");
				int id = Integer.parseInt(sc.nextLine());
				
				Pelicula pelicula = gp.obtener(id);
				if (pelicula == null) System.out.println("No se ha encontrado la pel�cula");
				else System.out.println(pelicula);
			} else if (opcion.equals("5")) {
				List<Pelicula> listaPeliculas = gp.listar();
				
				if (listaPeliculas.size() > 0) {
					for (Pelicula pelicula : listaPeliculas) {
						System.out.println(pelicula);
					}
					
				} else
					System.out.println("No se han encontrado ninguna pel�cula");
				System.out.println("Introduzca el id de la pel�cula a buscar");
			}
			
		} while (!opcion.equals("0"));
		
		
		System.out.println("Aplicaci�n terminada");
		sc.close();
	}

}
