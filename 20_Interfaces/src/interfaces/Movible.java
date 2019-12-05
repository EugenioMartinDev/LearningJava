package interfaces;

/**
 * Interfaz que proporciona movimiento a los objetos
 * @author aula2m
 *
 */
public interface Movible {

	//Todos los métodos de una interfaz son públicos y abstractos por DEFECTO
	//Si se intenta definir private da un error de compilación
	
	//Admiten atributos pero como CONSTANTES (por DEFECTO son static final)
	String DISTANCIA_STANDARD = "LEGUA";
	
	void moverseLento(); 
	void moverse(int metros);
}
