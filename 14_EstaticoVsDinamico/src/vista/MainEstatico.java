package vista;

import modelo.entidad.Persona;

public class MainEstatico {

	// Ojo: main es est�tico, ya que debe existir antes de un 
	// objeto para que la JVM lo ejecute antes del comienzo de la instanciaci�n
	public static void main(String[] args) {
		
		Persona p1 = new Persona();
		//Se accede al m�todo setNombre a trav�s del objeto
		p1.setNombre("Juan");
		p1.setEdad(85);
		//El atributo numeroPersonas es est�tico (y p�blico, claro). Depende de la
		//clase y no de ning�n objeto. Todos los objetos comparten ese atributo.
		Persona.numeroPersonas ++;

		//El m�todo imprimirEstatico (funci�n imprimir) se puede llamar desde un m�todo
		//est�tico, sin instanciar ning�n objeto, porque se ha definido imprimir
		//como est�tico.
		imprimirEstatico(p1);
		
		//El m�todo imprimirDinamico se debe llamar desde un objeto (new MainEstatico)
		//porque el m�todo est�tico main no ve a los m�todos din�micos directamente.
		new MainEstatico().imprimirDinamico(p1);
		
		System.out.println("N�mero de personas : " + Persona.numeroPersonas);

	}

	public static void imprimirEstatico(Persona persona) {
		
		System.out.println(persona);
		
	}
	
	public void imprimirDinamico(Persona persona) {
		
		System.out.println(persona);
		
	}
	
}
