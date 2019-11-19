package testbeans;

import java.util.Scanner;

import beans.Departamento;

public class testDepartamento {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Departamento dep1, dep2, dep3;
		
		dep1 = new Departamento(10, "Ventas");
		dep2 = new Departamento();
		dep2.setIdDepartamento(20);
		dep2.setNombre("Administracion");
		
		dep3 = new Departamento();
		
		System.out.println("número de departamento : ");
		dep3.setIdDepartamento(Integer.parseInt(sc.next()));
		//dep3.setIdDepartamento(sc.nextInt());
		System.out.println("nombre de departamento : ");
		dep3.setNombre(sc.next());
		
		System.out.println("DATOS DE LOS DEPARTAMENTOS");
		System.out.println(dep1);
		System.out.println(dep2);
		System.out.println(dep3);
		System.out.println("DATOS SUELTOS");
		System.out.println("id dep1 : " + dep1.getIdDepartamento());
		System.out.println("nombre dep2 : " + dep2.getNombre());
		
		sc.close();

	}

}
