package hilo;

import java.util.Date;

public class HiloCalculoPrimo implements Runnable {

	//Ejercicio que queremos simular un procesamiento
	//simultáneo de cálculo de números primos.
	//Queremos abrir 5 hilos que calculen si un número
	//es primo o no. El número se pasa al hilo para que 
	//pueda analizar si es primo.
	//Cada hilo, cuando acabe, dirá si su número pasado es 
	//o no primo.
	
	private long numeroPrimo;
	private String nombre;
	
	public HiloCalculoPrimo(long numeroPrimo, String nombre) {
		this.numeroPrimo = numeroPrimo;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		System.out.println(nombre + " - calculando si el número " + numeroPrimo + " es primo ....");
		
		//Date contiene el número de milisegundos a partir de 1970 (tiempo unix)
		Date dateInicial = new Date();
		
		boolean esPrimo = true;
		for (long i = 2; i<numeroPrimo; i++) {
			if (numeroPrimo % i == 0) {
				System.out.println("Hilo : " + nombre + " el número " + numeroPrimo + " es divisible por  " + i);
				esPrimo = false;
				break;
			}
		}
		
		Date dateFinal = new Date();
		
		long tiempoTranscurrido = dateFinal.getTime() - dateInicial.getTime();
		
		System.out.println("Hilo : " + nombre + " terminado");
		System.out.println("Hilo : " + nombre + " es el número " + numeroPrimo + " primo ? " + esPrimo);
		System.out.println("Hilo : " + nombre + " ha empleado " + tiempoTranscurrido + " milisegundos ");
		
	}
	


	
	

}
