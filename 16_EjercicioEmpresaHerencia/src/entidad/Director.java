package entidad;

import java.util.ArrayList;

public class Director extends Empleado {

	ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

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
		return "Director [listaEmpleados=" + listaEmpleados + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getSalarioBase()=" + getSalarioBase() + ", getEdad()=" + getEdad() + "]";
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
