package beans;

public class TodosLosEmpleados implements CrudEmpleados{
	
	public boolean alta(Empleado empleado) {
		return false;
	};
	
	public Empleado baja(int idEmpleado) {
		Empleado emp = new Operativo();
		return emp;
	};
	
	public Empleado findById(int idEmpleado) {
		Empleado emp = new Operativo();
		return emp;
	};
	
	public Empleado[] findAll() {
		Empleado[] emp = {new Operativo(),new Operativo()};
		return emp;
	};


}
