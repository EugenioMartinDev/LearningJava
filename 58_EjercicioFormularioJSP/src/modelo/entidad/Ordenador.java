package modelo.entidad;

import java.util.List;

public class Ordenador {
	private String ram;
	private String procesador;
	private String[] arrayPerifericos;
	private List<String> listaPerifericos;
	
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getProcesador() {
		return procesador;
	}
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	public String[] getArrayPerifericos() {
		return arrayPerifericos;
	}
	public void setArrayPerifericos(String[] arrayPerifericos) {
		this.arrayPerifericos = arrayPerifericos;
	}
	public List<String> getListaPerifericos() {
		return listaPerifericos;
	}
	public void setListaPerifericos(List<String> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}
	@Override
	public String toString() {
		return "Ordenador [ram=" + ram + ", procesador=" + procesador + ", listaPerifericos=" + listaPerifericos + "]";
	}

	

}
