package cliente.vista;

import java.util.Scanner;

import cliente.ClienteAltaCoche;
import modelo.entidad.Coche;

public class CarData {

	public CarData() {
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Coche coche = new Coche();
		
		System.out.println("Alta de coche - Introduce los datos ");
		System.out.println("=================================== ");
		System.out.println("Matrícula : ");
		coche.setMatricula(sc.nextLine());
		System.out.println("Marca : ");
		coche.setMarca(sc.nextLine());
		System.out.println("Modelo : ");
		coche.setModelo(sc.nextLine());
		
		ClienteAltaCoche clienteAltaCoche = new ClienteAltaCoche(coche);
		
		String resultado = clienteAltaCoche.pedirAlta();
		
		System.out.println(resultado);
		System.out.println("El cliente ha finalizado");
	}
	
}
