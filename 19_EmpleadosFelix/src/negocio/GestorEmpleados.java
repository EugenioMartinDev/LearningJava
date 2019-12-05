package negocio;

import java.util.ArrayList;

import entidad.Empleado;

public class GestorEmpleados {
	private ArrayList<Empleado> listaEmpleados;

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

	public void alta(Empleado empleado) {
		listaEmpleados.add(empleado);
	}
	
}
