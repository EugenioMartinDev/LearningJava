package main;

import java.util.ArrayList;

import bean.Direccion;
import bean.Persona;

public class MainPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona p1 = new Persona();
		Persona pAux = p1;
		p1.setNombre("Bud Spencer");
		p1.setEdad(89);
		p1.setPeso(120);

		Persona p2 = new Persona("Terence Hill", 67, 70);

		pAux.setEdad(33);

		System.out.println(p1.getEdad());

		cambiarEdad(p1);

		System.out.println(p1.getEdad());

		p2 = pAux;

		int numero = 50;
		cambiarEntero(numero);
		System.out.println(numero);

		System.out.println(p1.equals(p2));

		System.out.println(p1);

		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

		Persona p3 = new Persona();
		p3.setNombre("Harry Potter");
		p3.setEdad(19);
		p3.setPeso(56);

		listaPersonas.add(p3);
		listaPersonas.add(p2);

		System.out.println(listaPersonas.get(0));

		/*
		 * OJO!! 01234 es un n�mero octal pues empieza por cero 0x3fa es un n�mero
		 * hexadecimal pues empieza por 0x 0b001 es un n�mero binario pues empieza por
		 * 0b int cp = 01234; System.out.println(cp);
		 */

		Persona p4 = new Persona();
		p4.setNombre("Mortadelo");
		p4.setEdad(80);
		p4.setPeso(70);
		Direccion d1 = new Direccion();
		d1.setCiudad("Madrid");
		d1.setNombreVia("Gran Via");
		d1.setTipoVia("Calle");
		d1.setCp("28054");
		p4.setDireccion(d1);

		listaPersonas.add(p4);

	}

	public static void cambiarEdad(Persona p) {
		p.setEdad(45);
	}

	public static void cambiarEntero(int numero) {
		numero = 100;
	}

}
