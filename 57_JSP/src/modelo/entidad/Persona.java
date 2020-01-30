package modelo.entidad;

public class Persona {
	private String nombre;
	private double pesoKilos;
	private double pesoLibras;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	public double getPesoKilos() {
		return pesoKilos;
	}
	public void setPesoKilos(double pesoKilos) {
		this.pesoKilos = pesoKilos;
	}
	public double getPesoLibras() {
		return pesoLibras;
	}
	public void setPesoLibras(double pesoLibras) {
		this.pesoLibras = pesoLibras;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", pesoKilos=" + pesoKilos + ", pesoLibras=" + pesoLibras + "]";
	}
	
	
}
