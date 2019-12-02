package vista;

import java.util.ArrayList;
import java.util.Scanner;

import entidad.Director;
import entidad.Empleado;
import entidad.JefeProyecto;
import entidad.Programador;
import excepcionempleado.ExcepcionEmpleado;
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
				if (e != null) ge.alta(e);
				break;
			case "2":
				for (Empleado empleado : ge.getListaEmpleados()) {
					System.out.println(empleado);
				}
				break;
			case "3":
				for (Empleado empleado : ge.getListaEmpleados()) {
					System.out.println(empleado.getClass().getSimpleName() + " - " + empleado.getNombre() + " - " + empleado.calcularSalario() + " € ");
				}
				break;
			default:
				if (!opcion.equals("0")) System.out.println(" Introduce 1, 2 ó 3");
				break;
			}

		} while (!opcion.equals("0"));

		System.out.println("Gracias por usar nuestra app");

	}

	private static Empleado pedirEmpleado() {
		String opcion = "";
		Empleado empleado = null;
		do {
			opcion = mostrarMenuTipoEmpleado();
			switch (opcion) {
			case "1":
				empleado = pedirProgramador();
				break;
			case "2":
				empleado = pedirJefeProyecto();
				break;
			case "3":
				try {
					empleado = pedirDirector();
				} catch (ExcepcionEmpleado e) {
					System.out.println("No se puede crear un director por falta de empleados");
				}
				break;
			default:
				System.out.println("Opciones 1, 2 ó 3");
				break;

			}
		} while (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")));
				
		return empleado;
	}

	private static Empleado pedirDirector()  throws ExcepcionEmpleado {

		if (ge.getListaEmpleados().size() == 0) throw new ExcepcionEmpleado();
		
		Director director = new Director();

		director.setNombre(validarString("nombre"));
		director.setDni(validarString("dni"));
		director.setEdad(validarInt("edad"));
		director.setSalarioBase(validarDouble("salarioBase"));
	
		ArrayList<Empleado> listaEmpleadosDelDirector = pedirEmpleadosDelDirector();

		director.setListaEmpleados(listaEmpleadosDelDirector);

		return director;
	}

	private static Empleado pedirJefeProyecto() {
		JefeProyecto jefeProyecto = new JefeProyecto();

		jefeProyecto.setNombre(validarString("nombre"));		
		jefeProyecto.setDni(validarString("dni"));
		jefeProyecto.setEdad(validarInt("edad"));
		jefeProyecto.setIncentivo(validarDouble("incentivo"));
		jefeProyecto.setSalarioBase(validarDouble("salarioBase"));

		return jefeProyecto;
	}

	private static ArrayList<Empleado> pedirEmpleadosDelDirector(){
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados.addAll(ge.getListaEmpleados());		
		ArrayList<Empleado> listaEmpleadosDelDirector = new ArrayList<Empleado>();

		String posicionEmpleado = null;

		do {
			int indice = 0;
			System.out.println("Elija el índice de un empleado (-1 para salir)");
			for (Empleado empleado : listaEmpleados) {
				System.out.println(indice + " - " + empleado);
				indice++;
			}

			boolean repetir = true;
			do {
				posicionEmpleado = sc.nextLine();
				if (!posicionEmpleado.equals("-1")) {
					try {						
						listaEmpleadosDelDirector.add(listaEmpleados.get(Integer.parseInt(posicionEmpleado)));
						listaEmpleados.remove(Integer.parseInt(posicionEmpleado));						
						repetir = false;
					} catch (NumberFormatException e) {
						System.out.println("La posición no puede ser un carácter");
						System.out.println("Elija el índice de un empleado (-1 para salir)");
					} catch (IndexOutOfBoundsException ex) {
						System.out.println("El índice es superior al número de empleados");
					}
				} else {
					repetir = false;
				}
			} while (repetir);
		} while (!posicionEmpleado.equals("-1"));

		return listaEmpleadosDelDirector;
	}

	private static Empleado pedirProgramador() {
		Programador programador = new Programador();

		programador.setNombre(validarString("nombre"));
		programador.setDni(validarString("dni"));				
		programador.setEdad(validarInt("edad"));		
		programador.setSalarioBase(validarDouble("salarioBase"));

		return programador;
	}

	private static String validarString(String stringType) {
		String string = "";
		boolean repMenu = true;
		do  {
			string = pedirDato(stringType);	
			if (!(string.isEmpty())) {
				repMenu = false;
			} else {
				System.out.println("Necesitas meter " + stringType);
			}	

		} while (repMenu);
		
		return string;
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

	private static double validarDouble(String sDoubleType) {
		Double dDouble = 0.0;
		boolean repetir = true;
		do {
			String sDouble = pedirDato(sDoubleType);		
			try {
				dDouble = Double.parseDouble(sDouble);
				repetir = false;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("No se admiten caracteres");
			}
		
		}while (repetir);
		return dDouble;
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
