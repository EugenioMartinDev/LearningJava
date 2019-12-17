package basico;

public class LanzadorHilos {
	
	//Ejercicio que queremos simular un procesamiento
	//simult�neo de c�lculo de n�meros primos.
	//Queremos abrir 5 hilos que calculen si un n�mero
	//es primo o no. El n�mero se pasa al hilo para que 
	//pueda analizar si es primo.
	//Cada hilo, cuando acabe, dir� si su n�mero pasado es 
	//o no primo.

	public static void main(String[] args) {
		 
		HiloThread ht1 = new HiloThread("primero");
		HiloThread ht2 = new HiloThread("segundo");
		
		ht1.start();
		ht2.start();
		
		HiloRunnable hr1 = new HiloRunnable("tercero");
		HiloRunnable hr2 = new HiloRunnable("cuarto");
		
		//El hilo que se crea con el interfaz runnable
		//se arranca a trav�s de un objeto de clase Thread.
		Thread t1 = new Thread(hr1);
		t1.start();
		Thread t2 = new Thread(hr2);
		t2.start();
		

		//ht1.run();
		//ht2.run();

	}

}
