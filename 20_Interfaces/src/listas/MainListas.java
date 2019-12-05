package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class MainListas {

	public static void main(String[] args) {
		
		//Referencia a la implementaci�n
		ArrayList<String> listaStrings = new ArrayList<String>();
		listaStrings.add("pepe");
		listaStrings.add("pepa");
		
		//Referencia a la interfaz
		List<String> listaStrings2 = new ArrayList<String>();
		listaStrings2.add("pepe");
		listaStrings2.add("pepa pig");
		
		//Las interfaces son una colecci�n de m�todos abstractos
		//Sirven para varias cosas, entre �llas, implementar
		//una herencia m�ltiple en Java.
		//Con una referencia a una interfaz podemos apuntar a 
		//cualquier objeto que implemente a dicha interfaz.
		//Las interfaces dice el "qu�", mientras que sus implementacines
		//dicen el "c�mo".
		//Ejemplo, la clase ArrayList es una implementaci�n de la 
		//interfaz List. La clase ArrayList, por debajo, usa arrays, y 
		//cuando se llega, crea uno nuevo mayor y copia los valores del viejo.
		
		//Y supongamos que trabajamos con ArrayList que recibimos de la delegaci�n de Madrid,
		//LinkedList que recibimos de la delegaci�n de Barcelona, y vector de Sevilla.
		//Recorrer las listas de las tres delegaciones supone tener tres referencias y tres
		//m�todos
		LinkedList<String> listaLinked = new LinkedList<String>();
		ArrayList<String> listaArray = new ArrayList<String>();
		Vector<String> listaVector = new Vector<String>();
		
		recorrerLinked(listaLinked);
		recorrerArray(listaArray); 
		recorrerVector(listaVector);
		
		//Gracias a la referencia a la interfaz 
		//solo necesitamos un �nico m�todo recorrer sobre List
		
		recorrer(listaLinked);
		recorrer(listaArray); 
		recorrer(listaVector);
	
	}

	private static void recorrerLinked(LinkedList<String> lista) {
		for (String s: lista) {
			System.out.println(s);
		}
	}
	
	private static void recorrerArray(ArrayList<String> lista) {
		for (String s: lista) {
			System.out.println(s);
		}
	}
	
	private static void recorrerVector(Vector<String> lista) {
		for (String s: lista) {
			System.out.println(s);
		}
	}
	
	private static void recorrer(List<String> lista) {
		for (String s: lista) {
			System.out.println(s);
		}
	}
	
}
