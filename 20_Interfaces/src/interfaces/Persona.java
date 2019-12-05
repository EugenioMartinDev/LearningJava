package interfaces;

//Las interfaces nos ayudan a simular una herencia múltiple.
//Podemos implementar muchas interfaces, separadas por comas.
public class Persona implements Movible {
	private String nombre;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void moverseLento() {
		System.out.println("Me llamo " + nombre + " y me muevo 2 metros");
		
	}

	@Override
	public void moverse(int metros) {
		System.out.println("Me llamo " + nombre + " y me muevo " + metros + " metros");
		
	}
	
	
}
