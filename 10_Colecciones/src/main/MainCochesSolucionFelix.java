package main;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Coche;

public class MainCochesSolucionFelix {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
				
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		int opcion = 0;
		
		do {
			opcion = mostrarMenu();
			if (opcion == 1) {
				Coche coche = altaCoche();
				listaCoches.add(coche);
			}
			if (opcion == 2) {
				listarCoches(listaCoches);
			}
		} while (opcion != 0);
		
		System.out.println("Fin del programa");
		

	}

	private static void listarCoches(ArrayList<Coche> listaCoches) {
		for (Coche coche : listaCoches) {
			System.out.println(coche);
		}
		
	}

	private static Coche altaCoche() {
		
		System.out.println("Introduzca la matr�cula : ");
		String matricula = sc.next();
		
		System.out.println("Introduzca la marca : ");
		String marca = sc.next();
		
		System.out.println("Introduzca el modelo : ");
		String modelo = sc.next();
		
		Coche coche = new Coche();
		coche.setMatricula(matricula);
		coche.setMarca(marca);
		coche.setModelo(modelo);
		
		return coche;
	}

	private static int mostrarMenu() {
		
		
		System.out.println("1- Alta de coche");
		System.out.println("2- Listar coches");
		System.out.println("0- Salir del programa");
		
		int opcion = sc.nextInt();
		
		if (opcion < 0 || opcion > 2) {
			System.out.println("Opci�n elegida no es v�lida");
		}
		
		return opcion;
	}

}
