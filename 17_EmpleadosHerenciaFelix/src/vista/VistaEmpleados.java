package vista;

import java.util.ArrayList;
import java.util.Scanner;

import entidad.Director;
import entidad.Empleado;
import entidad.JefeProyecto;
import entidad.Programador;
import negocio.GestorEmpleados;

public class VistaEmpleados {

	static Scanner sc = null;
	static GestorEmpleados ge = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		ge = new GestorEmpleados();
		ge.setListaEmpleados(new ArrayList<Empleado>());

		String opcion = "";

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case "1":
				Empleado e = pedirEmpleado();
				ge.alta(e);
				break;
			case "2":
				for (Empleado empleado : ge.getListaEmpleados()) {
					System.out.println(empleado);
				}
				break;
			case "3":
				for (Empleado empleado : ge.getListaEmpleados()) {
					System.out.println(empleado.getNombre() + " - " + empleado.calcularSalario());
				}
				break;
			default:
				break;
			}

		} while (!opcion.equals("0"));

		System.out.println("Gracias por usar nuestra app");

	}

	private static Empleado pedirEmpleado() {
		String opcion = mostrarMenuTipoEmpleado();
		Empleado empleado = null;
		switch (opcion) {
		case "1":
			empleado = pedirProgramador();
			break;
		case "2":
			empleado = pedirJefeProyecto();
			break;
		case "3":
			empleado = pedirDirector();
			break;
		default:
			System.out.println("Opciones 1, 2 ó 3");
			break;

		}
		return empleado;
	}

	private static Empleado pedirDirector() {
		Director director = new Director();
		String nombre = pedirDato("nombre");
		String dni = pedirDato("dni");
		String edad = pedirDato("edad");
		String salarioBase = pedirDato("salarioBase");

		ArrayList<Empleado> listaEmpleadosDelDirector = pedirEmpleadosDelDirector();

		director.setNombre(nombre);
		director.setDni(dni);
		director.setEdad(Integer.parseInt(edad));
		director.setSalarioBase(Double.parseDouble(salarioBase));
		director.setListaEmpleados(listaEmpleadosDelDirector);

		return director;
	}

	private static Empleado pedirJefeProyecto() {
		JefeProyecto jefeProyecto = new JefeProyecto();
		String nombre = pedirDato("nombre");
		String dni = pedirDato("dni");
		String edad = pedirDato("edad");
		String salarioBase = pedirDato("salarioBase");
		String incentivo = pedirDato("incentivo");

		jefeProyecto.setNombre(nombre);
		jefeProyecto.setDni(dni);
		jefeProyecto.setEdad(Integer.parseInt(edad));
		jefeProyecto.setSalarioBase(Double.parseDouble(salarioBase));
		jefeProyecto.setIncentivo(Double.parseDouble(incentivo));

		return jefeProyecto;
	}

	private static ArrayList<Empleado> pedirEmpleadosDelDirector() {
		ArrayList<Empleado> listaEmpleados = ge.getListaEmpleados();
		ArrayList<Empleado> listaEmpleadosDelDirector = new ArrayList<Empleado>();

		String posicionEmpleado = null;

		do {
			int indice = 0;
			System.out.println("Elija el índice de un empleado (-1 para salir)");
			for (Empleado empleado : listaEmpleados) {
				System.out.println(indice + " - " + empleado);
				indice++;
			}
			posicionEmpleado = sc.nextLine();
			if (!posicionEmpleado.equals("-1")) {
				listaEmpleadosDelDirector.add(listaEmpleados.get(Integer.parseInt(posicionEmpleado)));
			}
		} while (!posicionEmpleado.equals("-1"));

		return listaEmpleadosDelDirector;
	}

	private static Empleado pedirProgramador() {
		Programador programador = new Programador();
		String nombre = pedirDato("nombre");
		String dni = pedirDato("dni");
		String edad = pedirDato("edad");
		String salarioBase = pedirDato("salarioBase");

		programador.setNombre(nombre);
		programador.setDni(dni);
		programador.setEdad(Integer.parseInt(edad));
		programador.setSalarioBase(Double.parseDouble(salarioBase));

		return programador;
	}

	private static String pedirDato(String dato) {
		System.out.println("Introduzca " + dato + " : ");
		return sc.nextLine();
	}

	private static String mostrarMenuTipoEmpleado() {
		System.out.println("1- Programador");
		System.out.println("2- Jefe de Proyecto");
		System.out.println("3- Director");

		String opcion = sc.nextLine();

		return opcion;
	}

	private static String mostrarMenu() {
		System.out.println("1- alta empleado");
		System.out.println("2- listar empleado");
		System.out.println("3- mostrar salarios");
		System.out.println("0- terminar programa");

		String opcion = sc.nextLine();

		return opcion;
	}

}
