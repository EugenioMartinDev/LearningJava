package vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.negocio.GestorPeliculas;
import modelo.negocio.Pelicula;
import modelo.persistencia.DaoPelicula;

public class vistaPeliculas {

	static Scanner sc = null;
	static GestorPeliculas gp = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		DaoPelicula daoPelicula = new DaoPelicula();

		gp = new GestorPeliculas();
		gp.setDaoPelicula(daoPelicula);

		String opcion = "";

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case "1":
				Pelicula pelicula = pedirPelicula();
				if (pelicula != null) {
					try {
						int resultado = gp.altaPelicula(pelicula);
						if (resultado == 0) {
							System.out.println("Película del título" + pelicula.getTitulo() + " insertada con éxito");
						} else if (resultado == 1)
							System.out.println("Alguno de los campos tiene un valor vacío o cero");
						else if (resultado == 2)
							System.out.println("No se ha podido actualizar la base de datos");
						else
							System.out.println("Error desconocido");

					} catch (SQLException e) {
						System.out.println("Error en el acceso a la base de datos");
						e.printStackTrace();
					}
				}

				break;
			case "2":

				String subOpcion = "";
				do {
					subOpcion = mostrarSubMenuEleccion();

					if (subOpcion.equals("1")) {

						try {
							List<Pelicula> listaPeliculas = gp.listarPelicula();

							for (Pelicula elementoPelicula : listaPeliculas) {
								System.out.println(elementoPelicula);
							}

							int id = pedirIdentidad();

							try {
								if (gp.bajaPelicula(id))
									System.out.println("Película con identidad " + id + " se ha borrado con éxito");
								else
									System.out.println("No se ha encontrado la película con identidad " + id);
							} catch (SQLException e) {
								System.out.println("Error en el acceso a la base de datos");
								e.printStackTrace();
							}

						} catch (SQLException e) {
							System.out.println("Error en el acceso a la base de datos");
							e.printStackTrace();
						}

					}

					if (subOpcion.equals("2")) {
						int id = pedirIdentidad();

						try {
							if (gp.bajaPelicula(id))
								System.out.println("Película con identidad " + id + " se ha borrado con éxito");
							else
								System.out.println("No se ha encontrado la película con identidad " + id);
						} catch (SQLException e) {
							System.out.println("Error en el acceso a la base de datos");
							e.printStackTrace();
						}

					}
				} while (!subOpcion.equals("0"));

				break;

			case "3":

				String subOpcionMod = "";
				do {
					subOpcionMod = mostrarSubMenuEleccion();

					if (subOpcionMod.equals("1")) {

						try {
							List<Pelicula> listaPeliculas = gp.listarPelicula();

							for (Pelicula elementoPelicula : listaPeliculas) {
								System.out.println(elementoPelicula);
							}

							int id = pedirIdentidad();

							Pelicula peliculaMod = pedirPelicula();
							peliculaMod.setId(id);

							try {
								int resultado = gp.modificarPelicula(peliculaMod);
								if (resultado == 0)
									System.out.println("Película con identidad " + id + " se ha borrado con éxito");
								else if (resultado == 1)
									System.out.println("Algún campo de la película es vacío o 0");
								else if (resultado == 2)
									System.out.println("Se ha producido un error en la modificación");
								else
									System.out.println("Error desconocido");
							} catch (SQLException e) {
								System.out.println("Error en el acceso a la base de datos");
								e.printStackTrace();
							}

						} catch (SQLException e) {
							System.out.println("Error en el acceso a la base de datos");
							e.printStackTrace();
						}

					}

					if (subOpcionMod.equals("2")) {

						int id = pedirIdentidad();

						Pelicula peliculaMod = pedirPelicula();
						peliculaMod.setId(id);

						try {
							int resultado = gp.modificarPelicula(peliculaMod);
							if (resultado == 0)
								System.out.println("Película con identidad " + id + " se ha borrado con éxito");
							else if (resultado == 1)
								System.out.println("Algún campo de la película es vacío o 0");
							else if (resultado == 2)
								System.out.println("Se ha producido un error en la modificación");
							else
								System.out.println("Error desconocido");
						} catch (SQLException e) {
							System.out.println("Error en el acceso a la base de datos");
							e.printStackTrace();
						}

					}
				} while (!subOpcionMod.equals("0"));

				break;

			case "4":

				int id = pedirIdentidad();

				try {
					Pelicula peliculaBuscar = gp.buscarPelicula(id);
					if (peliculaBuscar != null)
						System.out.println("Película " + peliculaBuscar);
					else
						System.out.println("No se ha encontrado la película con identidad " + id);
				} catch (SQLException e) {
					System.out.println("Error en el acceso a la base de datos");
					e.printStackTrace();
				}

				break;

			case "5":

				String ordenada = "N";
				System.out.println("Desea una lista ordenada por año? (S/N)");
				ordenada = sc.nextLine().toUpperCase();
				List<Pelicula> listaPeliculas = null;

				try {
					if (ordenada.equals("S"))
						listaPeliculas = gp.listarPeliculaOrdenadaAnio();
					else
						listaPeliculas = gp.listarPelicula();
					if (listaPeliculas.size() == 0)
						System.out.println("No existe ninguna película");
					else
						for (Pelicula elementoPelicula : listaPeliculas) {
							System.out.println(elementoPelicula);
						}
				} catch (SQLException e) {
					System.out.println("Error en el acceso a la base de datos");
					e.printStackTrace();
				}

				break;
			default:
				if (!opcion.equals("0"))
					System.out.println(" Introduce 1, 2, 3, 4 ó 5");
				break;
			}

		} while (!opcion.equals("0"));

		System.out.println("Gracias por usar nuestra app");

	}

	private static int pedirIdentidad() {

		return validarInt("identidad de la película");
	}

	private static Pelicula pedirPelicula() {
		Pelicula pelicula = new Pelicula();

		pelicula.setTitulo(pedirDato("título"));
		pelicula.setDirector(pedirDato("director"));
		pelicula.setGenero(pedirDato("genero"));
		pelicula.setAnioPublicacion(validarInt("año de publicación"));

		return pelicula;
	}

	private static int validarInt(String sIntType) {
		Integer iInt = 0;
		boolean repetir = true;
		do {
			String sInt = pedirDato(sIntType);
			try {
				Double dInt = Double.parseDouble(sInt);

				try {
					iInt = Integer.parseInt(sInt);
					repetir = false;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("No se admiten double");
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("No se admiten caracteres");
			}

		} while (repetir);
		return iInt;
	}

	private static String pedirDato(String dato) {
		System.out.println("Introduzca " + dato + " : ");
		return sc.nextLine();
	}

	private static String mostrarSubMenuEleccion() {
		System.out.println("\t\t1- Listar Películas");
		System.out.println("\t\t2- Incluir identidad");
		System.out.println("\t\t0- Terminar");

		String opcion = sc.nextLine();

		return opcion;
	}

	private static String mostrarMenu() {
		System.out.println("1- alta de película");
		System.out.println("2- baja de película por identidad");
		System.out.println("3- modifica la película por identidad");
		System.out.println("4- busca la película por identidad");
		System.out.println("5- Lista las películas");
		System.out.println("0- terminar programa");

		String opcion = sc.nextLine();

		return opcion;
	}

}
