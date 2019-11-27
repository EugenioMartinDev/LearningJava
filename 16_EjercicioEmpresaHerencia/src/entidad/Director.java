package entidad;

import java.util.ArrayList;

public class Director extends Empleado {

	private ArrayList<Empleado> listaEmpleados;
	public static final double VARIABLE_POR_EMPLEADO = 100.00;

	/**
	 * @return the listaEmpleados
	 */
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	/**
	 * @param listaEmpleados the listaEmpleados to set
	 */
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Director [getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getSalarioBase()=" + getSalarioBase() + ", getEdad()=" + getEdad() +  ", listaEmpleados=" + listaEmpleados + "]";
	}

	@Override
	public double sueldoTotal() {
		
		return super.sueldoTotal() + listaEmpleados.size()*100;
	}

	public void altaEmpleado(Empleado empleado) {
		listaEmpleados.add(empleado);
	}
	
	public void bajaEmpleado(Empleado empleado) {
		listaEmpleados.remove(empleado);
	}
	
}
