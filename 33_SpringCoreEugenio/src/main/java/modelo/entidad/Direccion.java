package modelo.entidad;

public class Direccion {

	private String nombreVia;
	private String tipoVia;
	private String ciudad;
	/**
	 * @return the nombreVia
	 */
	public String getNombreVia() {
		return nombreVia;
	}
	/**
	 * @param nombreVia the nombreVia to set
	 */
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	/**
	 * @return the tipoVia
	 */
	public String getTipoVia() {
		return tipoVia;
	}
	/**
	 * @param tipoVia the tipoVia to set
	 */
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Direccion [nombreVia=" + nombreVia + ", tipoVia=" + tipoVia + ", ciudad=" + ciudad + "]";
	}
	/**
	 * @param nombreVia
	 * @param tipoVia
	 * @param ciudad
	 */
	public Direccion(String nombreVia, String tipoVia, String ciudad) {
		super();
		this.nombreVia = nombreVia;
		this.tipoVia = tipoVia;
		this.ciudad = ciudad;
	}
	/**
	 * 
	 */
	public Direccion() {
		super();
	}
	
	
	
}
