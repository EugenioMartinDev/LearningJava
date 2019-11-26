package main;

import java.util.ArrayList;

import entidad.Director;
import entidad.Empleado;
import entidad.JefeProyecto;
import entidad.Programador;

public class MainEmpresa {

	/*
	 * 
	 * Una vez hecho el modelo de datos se pide probar el modelo creando 4 programadores, 2 jefes de proyecto
, 1 director (con 2 de esos programadores y un jefe de proyecto). Se meterán los empleados en un array
y se ejecutará el calcular sueldo total de cada uno de ellos para observar como el programa muestra
cada uno de los sueldos totales
	 */
	
	public static void main(String[] args) {
		
		Programador p1 = new Programador();
		p1.setDni("11111111A");
		p1.setEdad(38);
		p1.setNombre("Juan");
		p1.setSalarioBase(12000);
		
		Programador p2 = new Programador();
		p2.setDni("22222222B");
		p2.setEdad(43);
		p2.setNombre("José");
		p2.setSalarioBase(15000);
		
		Programador p3 = new Programador();
		p3.setDni("33333333C");
		p3.setEdad(25);
		p3.setNombre("Pablo");
		p3.setSalarioBase(11000);
		
		Programador p4 = new Programador();
		p4.setDni("44444444D");
		p4.setEdad(50);
		p4.setNombre("Angel");
		p4.setSalarioBase(17000);
		
		JefeProyecto jp1 = new JefeProyecto();
		jp1.setDni("55555555E");
		jp1.setEdad(47);
		jp1.setNombre("Carlos");
		jp1.setSalarioBase(30000);
		jp1.setIncentivo(8000);
		
		JefeProyecto jp2 = new JefeProyecto();
		jp2.setDni("66666666F");
		jp2.setEdad(50);
		jp2.setNombre("María");
		jp2.setSalarioBase(45000);
		jp2.setIncentivo(10000);
		
		Director d = new Director();
		d.setDni("77777777G");
		d.setEdad(45);
		d.setNombre("Lucía");
		d.setSalarioBase(60000);
		d.altaEmpleado(p1);
		d.altaEmpleado(p2);
		d.altaEmpleado(jp1);
		
		ArrayList<Empleado> empleadosEmpresa = new ArrayList<Empleado>();
		empleadosEmpresa.add(p1);
		empleadosEmpresa.add(p2);
		empleadosEmpresa.add(p3);
		empleadosEmpresa.add(p4);
		empleadosEmpresa.add(jp1);
		empleadosEmpresa.add(jp2);
		empleadosEmpresa.add(d);
		
		
		for (Empleado empleado : empleadosEmpresa) {
			System.out.println(" Sueldo de empleado " + empleado.getNombre() + " de cargo " + empleado.getClass().getSimpleName() + " es : "+ empleado.sueldoTotal());
		}
		
		/*
		
		System.out.println(" Sueldo del Programador 1 : " + p1.sueldoTotal());
		System.out.println(" Sueldo del Programador 2 : " + p2.sueldoTotal());
		System.out.println(" Sueldo del Programador 3 : " + p3.sueldoTotal());
		System.out.println(" Sueldo del Programador 4 : " + p4.sueldoTotal());
		
		System.out.println(" Sueldo del Jefe Proyecto 1 : " + jp1.sueldoTotal());
		System.out.println(" Sueldo del Jefe Proyecto 1 : " + jePro2.sueldoTotal());
		
		System.out.println(" Sueldo del director : " + dir.sueldoTotal());
		
		*/
	}

}
