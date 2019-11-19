package beans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Colecciones {
	
	Set<String> seta;
	Map<String, String> mapa;
	
	static List<String> lista1 = new ArrayList<String>();
	List<String> lista2 = new LinkedList<String>();
	List<String> lista3 = new Vector<String>();
	
	ArrayList<String> lista = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		lista1.add("pepe");
		lista1.add("eva");
		
		System.out.println(lista1.size());
		
		for (String ele : lista1) {
			System.out.println(ele);
		}
		
	}
	

}
