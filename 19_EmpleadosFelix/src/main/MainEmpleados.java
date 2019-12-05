package main;

import java.util.ArrayList;

import entidad.Director;
import entidad.Empleado;
import entidad.JefeProyecto;
import entidad.Programador;

public class MainEmpleados {

	public static void main(String[] args) {

		System.out.println(
				"Valor del sueldo variable por cada empleado del director : " + Director.VARIABLE_POR_EMPLEADO);

		ArrayList<Empleado> empresa = new ArrayList();

		Programador p1 = new Programador();
		p1.setNombre("Harry Potter");
		p1.setEdad(17);
		p1.setDni("12345678");
		p1.setSalarioBase(1500);

		empresa.add(p1);

		p1 = new Programador();
		p1.setNombre("Ernion Güesley");
		p1.setEdad(19);
		p1.setDni("12341234");
		p1.setSalarioBase(1200);

		empresa.add(p1);

		p1 = new Programador();
		p1.setNombre("Boldemor");
		p1.setEdad(23);
		p1.setDni("1234123423");
		p1.setSalarioBase(1600);

		empresa.add(p1);

		JefeProyecto jp1 = new JefeProyecto();
		jp1.setNombre("Draco Molfai");
		jp1.setEdad(33);
		jp1.setDni("341234114");
		jp1.setSalarioBase(2000);
		jp1.setIncentivo(300);

		empresa.add(jp1);

		jp1 = new JefeProyecto();
		jp1.setNombre("Jagris");
		jp1.setEdad(39);
		jp1.setDni("4524234");
		jp1.setSalarioBase(2100);
		jp1.setIncentivo(350);

		empresa.add(jp1);

		Director d1 = new Director();
		d1.setNombre("Dambeldor");
		d1.setEdad(150);
		d1.setDni("1");
		d1.setSalarioBase(2400);
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados.add(empresa.get(0)); // Programador Harry
		listaEmpleados.add(empresa.get(1)); // Programador Ernion
		listaEmpleados.add(empresa.get(3)); // Jefe de Proyecto Draco
		d1.setListaEmpleados(listaEmpleados);

		empresa.add(d1);

		for (Empleado empleado : empresa) {
			System.out.println(empleado.getNombre() + " tiene un sueldo de " + empleado.calcularSalario());
		}

	}

}
