package testbeans;
import beans.Empleado;

public class testEmpleado {

	public static void main(String[] args) {
		
		Empleado emp1 = new Empleado();
		Empleado emp2, emp3;
		
		emp2 = new Empleado();
		emp3 = new Empleado();
		Empleado emp4 = new Empleado(104, "juan", "sin miedo", "z", 15000, 44, 0.0, null);
		
		emp1.setIdEmpleado(100);
		emp1.setNombre("Tomas");
		emp1.setApellido("Escu delgado");
		emp1.setEdad(58);
		emp1.setSalario(25000);
		emp1.setSexo("h");
		
		emp2.setIdEmpleado(101);
		emp2.setNombre("Sara");
		emp2.setApellido("eScu dElgado");
		emp2.setEdad(3);
		emp2.setSalario(15000);
		emp2.setSexo("m");
		
		emp3.setIdEmpleado(102);
		emp3.setNombre("sebas");
		emp3.setApellido("escu Delgado");
		emp3.setEdad(33);
		emp3.setSalario(100);
		emp3.setSexo("H");

		
		System.out.println("Empleado 1 : " + emp1.getNombre());
		System.out.println("Objeto emp1 : " + emp1);
		System.out.println("Objeto emp2 : " + emp2);		
		System.out.println("Objeto emp3 : " + emp3);
		System.out.println("Objeto emp4 : " + emp4);

		System.out.println(" Nombre completo de emp1 " + emp1.nombreCompleto());
		System.out.println(" Salario mensual emp1 " + emp1.salarioMensual());
		System.out.println(" Salario repartido emp1 " + emp1.salarioMensual(12));
		
		System.out.println(" Salario antes del aumento de emp1 " + emp1.getSalario());
		System.out.println(" Salario despues de aumento de emp1 " + emp1.aumentarSalario(2000));
		System.out.println(" Salario total de emp1 " + emp1.getSalario());
		
	}

}
