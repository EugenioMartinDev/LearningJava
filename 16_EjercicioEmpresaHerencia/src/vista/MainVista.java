package vista;

import java.util.ArrayList;
import java.util.Scanner;

import entidad.Director;
import entidad.Empleado;
import entidad.JefeProyecto;
import entidad.Programador;

public class MainVista {

	/*
	 * Ejercicio Herencia 2
	 * 
	 * Siguiendo el modelo de datos de los empleados hacer un programa que haga lo
	 * siguiente
	 * 
	 * Mostrara un menu con los siguientes valores
	 * 
	 * 1- Alta empleado 2- Listar empleados 3- Calcular salario de los empleados 0-
	 * Salir del programa
	 * 
	 * Si pulsa 1, daremos de alta un empleado, pero nos preguntara cual 1- Alta
	 * programador 2- Alta jefe de proyecto 3- Alta director
	 * 
	 * En funcion de cual queramos crear, nos preguntara una serie de datos El alta
	 * director es el mas complicado, porque habria que preguntarle que empleados
	 * tiene a su cargo (podriamos mostrarle la lista de empleados actuales, y que
	 * elija 1)
	 * 
	 * si pulsa 2 mostraremos todos los empleados
	 * 
	 * si pulsa 3 recorremos el array mostrando los sueldos de cada empleado
	 * 
	 * 
	 */

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Empleado> empresa = new ArrayList<Empleado>();

		String opcion = "0";

		do {

			System.out.println("1- Alta de empleado");
			System.out.println("2- Lista de empleados");
			System.out.println("3- Calcular salario de empleados");
			System.out.println("0- Terminar el programa");
			opcion = sc.nextLine();

			if (opcion.equals("1")) {

				// Alta de empleado
				String opcionAlta = "1";
				System.out.println(" Tipo de empleado (Programador/Jefe de Proyecto/Director : ");
				System.out.println("1- Programador");
				System.out.println("2- Jefe de Proyecto");
				System.out.println("3- Director");
				opcionAlta = sc.nextLine();

				if (opcionAlta.equals("1")) {

					// Dar de alta programador
					Empleado programador = new Programador();
					LeerDatosEmpleado(programador);

					empresa.add(programador);

				} else if (opcionAlta.equals("2")) {

					// Dar de alta Jefe de Proyecto
					Empleado jefeProyecto = new JefeProyecto();
					LeerDatosEmpleado(jefeProyecto);

					System.out.println(" Incentivo : ");
					((JefeProyecto) jefeProyecto).setIncentivo(Double.parseDouble(sc.nextLine()));

					empresa.add(jefeProyecto);

				} else if (opcionAlta.equals("3")) {

					// Dar de alta Director
					Empleado director = new Director();
					LeerDatosEmpleado(director);

					ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
					((Director) director).setListaEmpleados(listaEmpleados);

					// Incluir en la lista de empleados del director 2 programadores y 1 jefe de
					// proyecto
					DarDeAltaEnListaDeDirector(empresa, (Director) director);

					empresa.add(director);

				} else {

					// Notificar que las opciones van de 1 a 3
					System.out.println("Las opciones son 1, 2 ó 3. Vuelve a intentarlo desde el menú principal");
				}

			} else if (opcion.equals("2")) {

				// Lista de empleados
				System.out.println(" Lista de empleados ");
				for (Empleado empleado : empresa) {
					System.out.println(empleado);
				}

			} else if (opcion.equals("3")) {

				// Calcular salario
				System.out.println("Cálculo del salario");
				for (Empleado empleado : empresa) {
					System.out.println(" El salario del " + empleado.getClass().getSimpleName() + " llamado "
							+ empleado.getNombre() + " es de " + empleado.sueldoTotal() + " euros");
				}

			} else if (!opcion.equals("0")) {

				// Avisar que las opciones van de 0 a 3.
				System.out.println(" Error en la opción. Tiene que tener un valor entre 0 y 3 (ambos incluídos)");

			}

		} while (!opcion.equals("0"));

		// Notificar fin de aplicación
		System.out.println(" Fin de la aplicación");

	}

	private static void DarDeAltaEnListaDeDirector(ArrayList<Empleado> empresa, Director director) {

		System.out.println(
				" Elije un programador para incluirlo como primero en la lista del director. Teclea el DNI del programador");
		for (Empleado empleado : empresa) {
			if (empleado instanceof Programador) {
				System.out.println(" Nombre " + empleado.getNombre() + " Dni " + empleado.getDni());
			}
		}
		String dni = sc.nextLine();

		for (Empleado empleado : empresa) {
			if (empleado.getDni().equals(dni)) {
				director.getListaEmpleados().add(empleado);
				break;
			}
		}

		System.out.println(
				" Elije otro programador para incluirlo como segundo en la lista del director. Teclea el DNI del programador");
		for (Empleado empleado : empresa) {
			if (empleado instanceof Programador) {
				if (!empleado.getDni().equals(dni)) {
					System.out.println(" Nombre " + empleado.getNombre() + " Dni " + empleado.getDni());
				}
			}
		}
		dni = sc.nextLine();

		for (Empleado empleado : empresa) {
			if (empleado.getDni().equals(dni)) {
				director.getListaEmpleados().add(empleado);
				break;
			}
		}

		System.out.println(" Elije jefe de proyecto de la lista. Teclea el DNI del jefe de proyecto");
		for (Empleado empleado : empresa) {
			if (empleado instanceof JefeProyecto) {
				System.out.println(" Nombre " + empleado.getNombre() + " Dni " + empleado.getDni());
			}
		}
		dni = sc.nextLine();

		for (Empleado empleado : empresa) {
			if (empleado.getDni().equals(dni)) {
				director.getListaEmpleados().add(empleado);
				break;
			}
		}

	}

	private static void LeerDatosEmpleado(Empleado programador) {

		System.out.println(" Nombre : ");
		programador.setNombre(sc.nextLine());

		System.out.println(" Edad : ");
		programador.setEdad(Integer.parseInt(sc.nextLine()));

		System.out.println(" DNI : ");
		programador.setDni(sc.nextLine());

		System.out.println(" Salario Base : ");
		programador.setSalarioBase(Double.parseDouble(sc.nextLine()));

	}

}
