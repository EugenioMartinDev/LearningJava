package basico;

public class HiloPrimos implements Runnable {
	
	private int numero;
	
	public HiloPrimos(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		
		if (numero <= 0) System.out.println("El número " + numero + " NO es primo");
		
		for (int i=2; i<=Math.sqrt(numero); i++) {
			if (numero%i == 0) {
				System.out.println("El número " + numero + " NO es primo"); 
				return;
			}
		}

		System.out.println("El número " + numero + " ES primo"); 
		
	}

	public static void main(String[] args) {
	
		Thread t1 = new Thread(new HiloPrimos(1307));
		Thread t2 = new Thread(new HiloPrimos(15193));
		Thread t3 = new Thread(new HiloPrimos(33377));
		Thread t4 = new Thread(new HiloPrimos(55411));
		//Thread t5 = new Thread(new HiloPrimos(1297*193));
		Thread t5 = new Thread(new HiloPrimos(13*13));
		
		

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
				
	}
	
}
