package modelo.entidad;


public class Direccion {

	private String tipoVia;
	private String nombreVia;
	private String ciudad;
	private String cp;
	
	
	
	/**
	 * 
	 */
	public Direccion() {
		super();
	}
	/**
	 * @param tipoVia
	 * @param nombreVia
	 * @param ciudad
	 * @param cp
	 */
	public Direccion(String tipoVia, String nombreVia, String ciudad, String cp) {
		super();
		this.tipoVia = tipoVia;
		this.nombreVia = nombreVia;
		this.ciudad = ciudad;
		this.cp = cp;
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
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", ciudad=" + ciudad + ", cp=" + cp + "]";
	}
	
	
	
	
}
