package testbeans;

import beans.Departamento;
import beans.Empleado;

public class TestRHHParte1 {
	
	public static void ejemplo(){
		
		Departamento dep30 = new Departamento(30,"ventas",null);
		Empleado emp114, emp115, emp116;
		
		emp114 = new Empleado(114, "Diego", "Martínez", "H", 25_000, 45, 2000, dep30);
		emp115 = new Empleado(115, "Sara", "Pérez", "M", 20_000, 35, 1000, dep30);
		emp116 = new Empleado(116, "Carlos", "Sánchez", "H", 35_000, 20, 0, dep30);
		dep30.setJefe(emp114);
		
		//Asignación de jefe que pertenece a otro departamento
		Departamento dep120 = new Departamento(120,"Formación",new Empleado(225, "Carmen", "González", "M", 70_000, 43, 10_000, dep30));
		dep120.getJefe().setDepartamento(dep120);
		
		Empleado emp300 = new Empleado(300, "Natalia", "Vázquez", "M", 60_000, 30, 5_500, dep30);
		Departamento dep130 = new Departamento(130, "Logística", emp300);
		emp300.setDepartamento(dep130);
		
		System.out.println("dep 120 : " + dep120.getNombre() + " --- dep del Jefe " + dep120.getJefe().getNombre() + " : " + dep120.getJefe().getDepartamento().getNombre());
		
		System.out.println("dep 130 : " + dep130.getNombre() + " --- dep del Jefe " + dep130.getJefe().getNombre() + " : " + dep130.getJefe().getDepartamento().getNombre());
		

		

		
		System.out.println("emp114 " + emp114);
		System.out.println("emp115 " + emp115);
		System.out.println("emp116 " + emp116);
		
		System.out.println("emp300 " + emp300);
		
		
		Departamento dep33 = new Departamento(33,"ventasLA",null);
		Empleado emp117 = new Empleado(117, "Carlos", "Sánchez", "M", 35_000, 20, 0, dep33);
		
		System.out.println(emp117);
		
		/*
		
		Departamento dep40 = new Departamento(40, "Formación", null);
		
		Empleado emp210 = new Empleado(210, "Sara", "Ruíz", "M", 120000, 45, 1000, dep40);
		
		Empleado emp300 = new Empleado(400, "José", "Sánchez", "H", 10000, 54, 1000, dep40);
		
		dep40.setJefe(emp300);
		
		System.out.println(emp210);
		System.out.println(emp300);
		
		*/
		
	}
	
	public static Departamento findById(int idDepartamento) {
		
		if (idDepartamento != 35) return null;
		
		Departamento dep35 = new Departamento(35,"ventas35",null);
		
		if (idDepartamento == 35)
		{
			return dep35;
		}
		
		return null;
	}

	public static void main(String[] args) {
		
		ejemplo();
		
		Departamento dep1 = null;
		dep1 = findById(35);
		System.out.println(dep1);

	}
	
	
	

}
