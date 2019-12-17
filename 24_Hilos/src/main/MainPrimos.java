package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import basico.HiloPrimos;

public class MainPrimos {
	
	public static final int limite = 100000;

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors
				.newFixedThreadPool(5, new ThreadFactory()
				{
					private int counter = 0;

					@Override
					public Thread newThread(Runnable r)
					{
						Thread t = new Thread(r, "HILO_DE_PRIMOS"+ "-" + counter++);
						return t;
					}

				});

		
		List<Integer> listaPrimos = Collections.synchronizedList(new ArrayList<Integer>());
		listaPrimos.add(1);
		listaPrimos.add(2);
		listaPrimos.add(3);
		
		for (int numero=4; numero<=limite; numero++)
		{

			
			Integer valor = numero;
			
			executorService.execute(new Runnable()
			{

				@Override
				public void run()
				{
					for (int i=2; i<=valor/2; i++) {
						if (valor%i == 0) {
							return;
						}
					}
					listaPrimos.add(valor);
				}
			});
		}
		

		//ht1.run();
		//ht2.run();
		
		executorService.shutdown(); // Disable new tasks from being submitted
		try {
			executorService.awaitTermination(1L, TimeUnit.HOURS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		Collections.sort(listaPrimos);
		System.out.println("Número de primos en los " + limite + " números : " + listaPrimos.size());
		int contador = 1;
		for (Integer primo : listaPrimos) {		
			if (contador%41 == 0 ) {
				System.out.println();
			}
			System.out.print(primo + " ");
			contador++;
		}




	}

}
