package basico;

public class HiloRunnable implements Runnable {

	private String nombreHilo;
	
	public HiloRunnable(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		System.out.println("Hola mundo Runnable " + nombreHilo);
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
