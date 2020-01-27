package modelo.entidad;

public class Rueda {

	private String marca;
	private String material;
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * @param marca
	 * @param material
	 */
	public Rueda(String marca, String material) {
		super();
		this.marca = marca;
		this.material = material;
	}
	/**
	 * 
	 */
	public Rueda() {
		super();
	}
	@Override
	public String toString() {
		return "Rueda [marca=" + marca + ", material=" + material + "]";
	}
	
}
