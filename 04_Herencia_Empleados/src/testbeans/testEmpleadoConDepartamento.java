package testbeans;

import beans.Departamento;
import beans.Empleado;

public class testEmpleadoConDepartamento {

	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado(200, "Eva", "P�rez", "M", 120000, 24, 1000, null);
		
		Departamento dep40 = new Departamento(40, "Formaci�n");
		
		Empleado emp210 = new Empleado(210, "Sara", "Ru�z", "M", 120000, 45, 1000, dep40);
		
		Empleado emp300 = new Empleado(400, "Jos�", "S�nchez", "H", 10000, 54, 1000, new Departamento(50, "VentaOnline"));
		
		Empleado emp500 = new Empleado(500, "Jaime", "S�nchez", "H", 20000, 42, 3000, dep40);
		
		/*
		 * Mostrar por consola
		 * 
		 * - nombre del empleado 2, salario del empleado 2 y nombre del departamento al que pertenece
		 * 
		 * -
		 * 
		 */
		
		System.out.println("Nombre empleado 2 : " + emp210.getNombre() + " salario : " + emp210.getSalario() + " departamento " + emp210.getDepartamento().getIdDepartamento());
		
		System.out.println(emp1);
		System.out.println(emp210);
		System.out.println(emp300);
		
		System.out.println(emp500);

	}

}
