package testbeans;

import beans.Departamento;
import beans.Director;
import beans.Empleado;
import beans.Gerente;

public class TestGerenteDirector {

	public static void main(String[] args) {

		Departamento d1; 
		Empleado e1, e2, e3;
		
		d1 = new Departamento(200, "ventas", null);
		e1 = new Empleado(1, "Eva", "Pérez", "M", 25_000, 30, 3_000, d1);
		d1.setJefe(e1);
		e2 = new Gerente(2, "Sara", "González", "M", 47_000, 45, 8_000, d1, 329, "999777666", 15_000);
		e3 = new Director(3, "Ana", "Márquez", "M", 60_000, 48, 12_000, d1, 3000, "pc");
		
		System.out.println("Departamento : " + d1);
		System.out.println("Empleado : " + e1);
		System.out.println("Gerente : " + e2);
		System.out.println("Director : " + e3);
		
		System.out.println(((Gerente) e2).totalSalario());
		
		System.out.println(((Director) e3).totalSalario());


	}

}
