package entidad;

public class Programador extends Empleado {

	@Override
	public double calcularSalario() {
		
		return getSalarioBase();
	}

}
