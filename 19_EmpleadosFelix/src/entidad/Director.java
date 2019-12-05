package entidad;

import java.util.ArrayList;

public class Director extends Empleado {

	private ArrayList<Empleado> listaEmpleados;
	public static final double VARIABLE_POR_EMPLEADO = 100.00;
	
	@Override
	public double calcularSalario() {
		
		return getSalarioBase() + (listaEmpleados.size()*VARIABLE_POR_EMPLEADO);
	}

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
		return "Director [" + super.toString() + " listaEmpleados=" + listaEmpleados + "]";
	}
	
	

}
