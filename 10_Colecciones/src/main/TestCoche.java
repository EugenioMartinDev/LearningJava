package main;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Coche;

public class TestCoche {
	
	ArrayList<Coche> listaCoches = new ArrayList<Coche>();
	
	public void a�adirCoche(Scanner sc) {
		
		System.out.println(" A�adiendo un nuevo coche ");
		
		Coche nuevoCoche = new Coche();
		
		System.out.println(" Introducir marca : ");
		nuevoCoche.setMarca(sc.next());
		
		System.out.println(" Introducir modelo : ");
		nuevoCoche.setModelo(sc.next());
		
		System.out.println(" Introducir matr�cula : ");
		nuevoCoche.setMatricula(sc.next());

		listaCoches.add(nuevoCoche);
					
	}
	
	public void listarCoches() {
		
		for (Coche coche : listaCoches) {
			System.out.println();
			System.out.println(coche);
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		TestCoche miTest = new TestCoche();

		boolean menuActivo = true;
		
		/* Men� para a�adir coches, listar coches y salir (1, 2 y  0)
		 * El men� est� siempre disponible.
		 * La opci�n 1 a�ade un nuevo coche (marca, modelo y matr�cula) a la memoria
		 * La opci�n 2 lista todos los coches a�adidos
		 * La opci�n 0 termina el programa
		 */
		
		
		
		Integer opcion = 0;
		Scanner sc = new Scanner(System.in);

		do {

			opcion = -1;
			
			while (opcion == -1) {
				
			System.out.println("Incluir un noche nuevo : 1 ");
			System.out.println("Lista de coches nuevos : 2 ");
			System.out.println("Acabar programa coches : 0 ");
			System.out.println("\tIntroducir opci�n 0, 1 � 2 ");
	
			String lectura = sc.nextLine(); 
			
			try{			
				  opcion = Integer.parseInt(lectura);
				  if (opcion < 0 || opcion > 3)
				  {
					  opcion = -1;
				  }
				} catch (Exception ex) {
				  System.out.println("Introduce un n�mero entero (0, 1, 2) ");
				}
			}
				
			switch(opcion) {		
			case 1:
				miTest.a�adirCoche(sc);

				break;
			case 2:
				miTest.listarCoches();
				break;
			case 0:
				System.out.println(" Terminado ");
				menuActivo = false;
				break;	
			default:
				System.out.println("\tPor favor, introducir opci�n 0, 1 � 2 ");
				System.out.println();
			}		

		} while (menuActivo);
		
		sc.close();
		
	}

}
