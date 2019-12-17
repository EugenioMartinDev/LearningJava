package basico;


// Para crear un hilo hay dos opciones:
// a) extender de la clase Thread
// b) implementar la interfaz runnable
public class HiloThread extends Thread {
	
	private String nombreHilo;
	
	public HiloThread(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		System.out.println("Hola mundo Thread " + nombreHilo);
		for (int i=0; i<=10; i++) {
			System.out.println("Contador de " + nombreHilo + " : " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //dormimos el hilo 200 milisegundos
		}
	}
}
