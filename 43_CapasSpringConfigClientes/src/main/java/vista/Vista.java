package vista;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.MainCliente;
import modelo.entidad.Cliente;
import modelo.negocio.GestorClientes;
import utils.Constantes;

public class Vista {

	private GestorClientes gc;
	private Scanner sc;
	
	/**
	 * @return the gc
	 */
	public GestorClientes getGc() {
		return gc;
	}

	/**
	 * @param gc the gc to set
	 */
	public void setGc(GestorClientes gc) {
		this.gc = gc;
	}

	/**
	 * @return the sc
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public void execute() {
	
		String opcion = "0";
		
		do {
			System.out.println("1- Alta de cliente");
			System.out.println("2- Lista de cliente");
			System.out.println("3- Buscar cliente por id");
			System.out.println("4- Buscar cliente por nombre");
			System.out.println("5- Borrar cliente por id");
			System.out.println("0- Terminar el programa");
			opcion = sc.nextLine();
			
			if (opcion.equals("1")) {
				Cliente cliente = MainCliente.context.getBean("cliente", Cliente.class);
				boolean dniCorrecto = true;
				String inputDni = "";
				do {
					dniCorrecto = true;
					System.out.println("DNI");
					inputDni = sc.nextLine();
					int resultado = gc.comprobarDNI(inputDni);
					if (Constantes.ERROR_DNI_LENGTH == resultado ) {
						System.out.println(" El DNI debe tener 9 caracteres");
						dniCorrecto = false;
					}
					if (Constantes.ERROR_DNI_WRONG_LETTER == resultado ) {
						System.out.println(" El DNI se compone de 8 dígitos y termina por letra : (T,R,W,A,G,M,Y,F,P,D,X,B,N,J,Z,S,Q,V,H,L,C,K,E)");
						dniCorrecto = false;
					}
						
				} while (!dniCorrecto);
				cliente.setDni(inputDni);
				
				System.out.println("NOMBRE");
				cliente.setNombre(sc.nextLine());

				boolean edadNumerica = false;
				int edadInput = 0;
				do {
					System.out.println("EDAD");
					try {
						edadInput = Integer.parseInt(sc.nextLine());
						edadNumerica = true;
					} catch (NumberFormatException ex) {
						System.out.println(" La edad tiene que ser numérica ");
					}					
				} while (!edadNumerica);
				cliente.setEdad(edadInput);
								
				int alta = gc.alta(cliente);
				if (alta == Constantes.ERROR_DNI_IS_NULL) System.out.println("El cliente necesita DNI");
				if (alta == Constantes.ERROR_DNI_IS_DUPLICATED) System.out.println("El DNI del cliente ya existe en la base de datos");
				if (alta == Constantes.ERROR_IN_DDBB) System.out.println("Ha fallado la base de datos");
				if (alta == Constantes.SUCCESSFULL_EXECUTION) System.out.println("Cliente actualizado en la base de datos");
			} else if (opcion.equals("2")) {
				List<Cliente> clientes = gc.lista();
				if (clientes.size() == 0) {
					System.out.println("No existe ningún cliente");
				} else {
					for (Cliente cliente : clientes) {
						System.out.println(cliente);
					}
				}
			} else if (opcion.equals("3")) {
				
				boolean idNumerica = false;
				int idInput = 0;
				do {
					System.out.println("Introduce la IDENTIDAD a buscar");
					try {
						idInput = Integer.parseInt(sc.nextLine());
						idNumerica = true;
					} catch (NumberFormatException ex) {
						System.out.println(" La identidad tiene que ser numérica ");
					}					
				} while (!idNumerica);
								
				Cliente cliente = gc.buscarPorId(idInput);
				if (cliente == null) {
					System.out.println("Cliente no encontrado");
				}
				else
					System.out.println(cliente);
			} else if (opcion.equals("4")) {
				System.out.println("Introduce NOMBRE a buscar");
				String nombre = sc.nextLine();
				List<Cliente> listaClientes = gc.buscarPorNombre(nombre);
				if (listaClientes.size() != 0) {
					for (Cliente cliente : listaClientes) {
						System.out.println(cliente);
					}
				} else {
					System.out.println("No se ha encontrado ningún cliente con ese nombre " + nombre);
				}
			} else if (opcion.equals("5")) {
				
				boolean idNumerica = false;
				int idInput = 0;
				do {
					System.out.println("Introduce la IDENTIDAD a borrar");
					try {
						idInput = Integer.parseInt(sc.nextLine());
						idNumerica = true;
					} catch (NumberFormatException ex) {
						System.out.println(" La identidad tiene que ser numérica ");
					}					
				} while (!idNumerica);
				
				if (gc.borrar(idInput)) {
					System.out.println(" Se ha borrado el cliente " + idInput);
				} else {
					System.out.println(" No se ha encontrado el cliente " + idInput);
				}
				
			}	 
			
		} while (!opcion.equals("0"));
		
		
		System.out.println("Aplicación terminada");
		sc.close();
	}

	
	
}
