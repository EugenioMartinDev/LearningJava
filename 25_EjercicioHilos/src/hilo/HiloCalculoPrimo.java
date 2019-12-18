package hilo;

import java.util.Date;

public class HiloCalculoPrimo implements Runnable {

	//Ejercicio que queremos simular un procesamiento
	//simult�neo de c�lculo de n�meros primos.
	//Queremos abrir 5 hilos que calculen si un n�mero
	//es primo o no. El n�mero se pasa al hilo para que 
	//pueda analizar si es primo.
	//Cada hilo, cuando acabe, dir� si su n�mero pasado es 
	//o no primo.
	
	private long numeroPrimo;
	private String nombre;
	
	public HiloCalculoPrimo(long numeroPrimo, String nombre) {
		this.numeroPrimo = numeroPrimo;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		System.out.println(nombre + " - calculando si el n�mero " + numeroPrimo + " es primo ....");
		
		//Date contiene el n�mero de milisegundos a partir de 1970 (tiempo unix)
		Date dateInicial = new Date();
		
		boolean esPrimo = true;
		for (long i = 2; i<numeroPrimo; i++) {
			if (numeroPrimo % i == 0) {
				System.out.println("Hilo : " + nombre + " el n�mero " + numeroPrimo + " es divisible por  " + i);
				esPrimo = false;
				break;
			}
		}
		
		Date dateFinal = new Date();
		
		long tiempoTranscurrido = dateFinal.getTime() - dateInicial.getTime();
		
		System.out.println("Hilo : " + nombre + " terminado");
		System.out.println("Hilo : " + nombre + " es el n�mero " + numeroPrimo + " primo ? " + esPrimo);
		System.out.println("Hilo : " + nombre + " ha empleado " + tiempoTranscurrido + " milisegundos ");
		
	}
	


	
	

}
