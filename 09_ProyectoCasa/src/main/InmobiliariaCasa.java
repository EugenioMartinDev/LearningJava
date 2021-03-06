package main;

import java.util.ArrayList;

import bean.Casa;
import bean.Direccion;
import bean.Habitacion;
import bean.Persona;

public class InmobiliariaCasa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona p1 = new Persona();
		p1.setNombre("Bud Spencer");
		p1.setEdad(89);
		p1.setPeso(120);

		Direccion d1 = new Direccion();
		d1.setCiudad("Madrid");
		d1.setNombreVia("Gran Via");
		d1.setTipoVia("Calle");
		d1.setCp("28054");

		p1.setDireccion(d1);

		Habitacion h1 = new Habitacion();
		h1.setM2(80);
		h1.setTipo("Salon");
		Habitacion h2 = new Habitacion();
		h2.setM2(20);
		h2.setTipo("Cocina");
		Habitacion h3 = new Habitacion();
		h3.setM2(15);
		h3.setTipo("Dormitorio1");
		Habitacion h4 = new Habitacion();
		h4.setM2(10);
		h4.setTipo("Dormitorio2");
		Habitacion h5 = new Habitacion();
		h5.setM2(10);
		h5.setTipo("Ba�o1");
		Habitacion h6 = new Habitacion();
		h6.setM2(10);
		h6.setTipo("Ba�o2");

		Direccion d2 = new Direccion();
		d2.setCiudad("Madrid");
		d2.setNombreVia("Castellana");
		d2.setTipoVia("Calle");
		d2.setCp("28033");

		Casa c1 = new Casa();
		c1.setPrecio(200_000);
		c1.setPropietario(p1);
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		listaHabitaciones.add(h1);
		listaHabitaciones.add(h2);
		listaHabitaciones.add(h3);
		listaHabitaciones.add(h4);
		listaHabitaciones.add(h5);
		listaHabitaciones.add(h6);
		c1.setListaHabitaciones(listaHabitaciones);
		c1.setDireccion(d2);

		System.out.println(c1);

	}

}
