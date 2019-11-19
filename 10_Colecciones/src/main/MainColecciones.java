package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.Persona;

public class MainColecciones {

	public static void main(String[] args) {
		
		ArrayList<String> listaNombre = new ArrayList<String>();
		listaNombre.add("Mortadelo");
		listaNombre.add("Filemon");
		listaNombre.add("Dr. Bacterio");
		listaNombre.add("Ofelio");
		listaNombre.add("Superintendente Vicente");
		
		System.out.println(listaNombre.get(0));
		System.out.println(listaNombre.get(3));
		System.out.println(listaNombre.size());
		
		//manero poco usada de recorrer listas
		for (int i=0; i<listaNombre.size(); i++) {
			System.out.println(listaNombre.get(i));
		}
		
		//manera OK para recorrer listas
		for (String elemento : listaNombre) {
			System.out.println(elemento);
		}
		
		
		listaNombre.forEach((n) -> System.out.println(n));
		
		System.out.println("******** array list de enteros *******");
		Integer entero = new Integer(4);
		Integer otroEntero = 5; //auto boxing
		ArrayList<Integer> listaEnteros = new ArrayList<Integer>();
		listaEnteros.add(entero);
		listaEnteros.add(otroEntero);
		listaEnteros.add(29);
		listaEnteros.add(new Integer(48));
		
		for (Integer elemento : listaEnteros) {
			System.out.println(elemento);
		}
		
		listaEnteros.forEach((n) -> System.out.println(n));
		
		listaEnteros.remove(1); //podemos eliminar por posición
		listaEnteros.remove(otroEntero); //o podemos eliminar por objeto
		
		for (Integer elemento : listaEnteros) {
			System.out.println(elemento);
		}
		
		double primitivo = 6.9;
		Double objetoDouble = 6.9;
		
		System.out.println("********** array list de personas **********");
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		
		Persona p1 = new Persona();
		p1.setNombre("Penelope");
		p1.setEdad("33");
		
		Persona p2 = new Persona();
		p2.setNombre("Ana");
		p2.setEdad("45");
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		
		// Excepción ----> IndexOutOfBoundsException  System.out.println(listaPersonas.get(15));
		
		for (Persona elemento : listaPersonas) {
			System.out.println("El nombre es : " + elemento.getNombre() + " y de edad : " + elemento.getEdad());
		}
		
		//**************************** MAP **************************
		System.out.println("***************  Mapas *****************");
		HashMap<String, String> mapaUsuarioContrasenia = new HashMap<String, String>();
		mapaUsuarioContrasenia.put("félix", "1234");
		mapaUsuarioContrasenia.put("pepe", "qwer");
		mapaUsuarioContrasenia.put("ana", "asdf");
		mapaUsuarioContrasenia.put("luis", "4321");
		mapaUsuarioContrasenia.put("félix", "243143");  // Sobreescribe el valor para la clave existente

		// siempre se accede por clave
		System.out.println(mapaUsuarioContrasenia.get("félix"));
		mapaUsuarioContrasenia.remove("félix");
		
		for (Map.Entry<String, String > entry : mapaUsuarioContrasenia.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		HashMap<String, Persona> mapaUsuarioPersona = new HashMap<String, Persona>();
		mapaUsuarioPersona.put(p1.getNombre(), p1);
		mapaUsuarioPersona.put(p2.getNombre(), p2);

		// Si la clave no existe se retorna el valor nulo.
		System.out.println(mapaUsuarioPersona.get("Penelope"));
		
		
	}

}
