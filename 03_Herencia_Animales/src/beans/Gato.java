package beans;

public class Gato extends Animal {

	private int vidas;

	/**
	 * 
	 */
	public Gato() {
		super();
	}

	/**
	 * @param vidas
	 */
	public Gato(int vidas) {
		super();
		this.vidas = vidas;
	}
		
	/**
	 * @param color
	 * @param vidas
	 */
	public Gato(String color, int vidas) {
		super(color);
		this.vidas = vidas;
	}		

	/**
	 * @param color
	 */
	public Gato(String color) {
		super(color);
	}

	/**
	 * @return the vidas
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * @param vidas the vidas to set
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	
	@Override
	public String toString() {
		return "Gato [color=" + color + ", vidas=" + vidas + "]";
	}
	
	
	public void trepar() {
		System.out.println("trepo y salto");
	}


	//Métodos reescritos de Animal
	
	@Override
	public void saludo() {
		System.out.println("Hola soy un gato y tengo " + vidas + " vidas");
		
		
	}

	@Override
	public void sonido() {
		System.out.println("Soy de color " + color + " y mi sonido es Maullo");
		
	}
	
	
}
