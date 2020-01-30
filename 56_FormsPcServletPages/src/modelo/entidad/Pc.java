package modelo.entidad;

import java.util.Arrays;

public class Pc {

	private String modelo;
	private String procesador;
	private String memoria;
	private String[] devices;
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the procesador
	 */
	public String getProcesador() {
		return procesador;
	}
	/**
	 * @param procesador the procesador to set
	 */
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	/**
	 * @return the memoria
	 */
	public String getMemoria() {
		return memoria;
	}
	/**
	 * @param memoria the memoria to set
	 */
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	/**
	 * @return the devices
	 */
	public String[] getDevices() {
		return devices;
	}
	/**
	 * @param devices the devices to set
	 */
	public void setDevices(String[] devices) {
		this.devices = devices;
	}
	@Override
	public String toString() {
		return "Pc [modelo=" + modelo + ", procesador=" + procesador + ", memoria=" + memoria + ", devices="
				+ Arrays.toString(devices) + "]";
	}

	
			
}
