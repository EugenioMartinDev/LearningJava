package beans;

public interface CrudEmpleados {

	public boolean alta(Empleado empleado);
	public Empleado baja(int idEmpleado);
	public Empleado findById(int idEmpleado);
	public Empleado[] findAll();

}
