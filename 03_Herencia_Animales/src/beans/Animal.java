package beans;

public class Animal {

	protected String color;

	/**
	 * 
	 */
	public Animal() {
		super();
	}

	/**
	 * @param color
	 */
	public Animal(String color) {
		super();
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Animal [color=" + color + "]";
	}
	
	public void saludo() {
		System.out.println("soy un animal");
	}
	
	public void sonido() {
		System.out.println("no sé que sonido hago");
	}
	
}
