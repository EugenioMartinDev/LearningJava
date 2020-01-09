package cliente.vista;

import java.util.Scanner;

import cliente.modelo.entidad.Pelicula;
import cliente.modelo.negocio.GestorClientePeliculas;

public class MainPeliculaCliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion = "0";
		GestorClientePeliculas gp = new GestorClientePeliculas();

		do {
			System.out.println("1- Alta de pelicula");
			System.out.println("2- Buscar pelicula por Id");
			System.out.println("3- Baja de pelicula por Id");
			System.out.println("0- Salir del programa");

			opcion = sc.nextLine();
			if (opcion.equals("1")) {
				System.out.println("Introduzca el id:");
				String id = sc.nextLine();
				System.out.println("Introduzca el titulo:");
				String titulo = sc.nextLine();
				System.out.println("Introduzca el nombre del director:");
				String director = sc.nextLine();

				gp.alta(id, titulo, director);
				// int alta = gp.altaPeli(p);
				System.out.println("Pelicula introducida correctamente");
				System.out.println("**********************************");

			} else if (opcion.equals("2")) {
				System.out.println("Introduzca el Id de la pelicula a buscar");
				String id = sc.nextLine();

				System.out.println("**********************************");
				Pelicula p = gp.buscar(id);
				System.out.println("La pelicula es: ");
				System.out.println(p);
			} else if (opcion.equals("3")) {
				System.out.println("Introduzca el Id de la peli que  desea buscar");
				String id = sc.nextLine();
				
				int resultado = gp.baja(id);
				if (resultado == 1) {
					System.out.println("La pelicula no se ha podido borrar");
				}else {
					System.out.println("Pelicula borrada");
				}
			}

		} while (!opcion.equals("0"));
		System.out.println("Gracias por usar nuestra Film App");
		sc.close();

	}
}