package entidad;

public class Programador extends Empleado {

	@Override
	public double calcularSalario() {
		
		return getSalarioBase();
	}

	@Override
	public String toString() {
		return "Programador [" + super.toString() + "]";
	}

}
