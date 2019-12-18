package hilo;

import java.util.Date;

public class MainCalculoPrimo {

	public static void main(String[] args) {
		
		
		Date date = new Date();
		
		System.out.println("Número de milisegundos transcurridos desde 1970 : " + date.getTime());
		
		//Si queremos poner valores long, si el rango es mayor que un int, hay que añadir la indicación L (o l minúscula>)
		HiloCalculoPrimo hcp1 = new HiloCalculoPrimo(5443, "Hilo1");
		HiloCalculoPrimo hcp2 = new HiloCalculoPrimo(104729, "Hilo2");
		HiloCalculoPrimo hcp3 = new HiloCalculoPrimo(2262626267623L, "Hilo3");
		HiloCalculoPrimo hcp4 = new HiloCalculoPrimo(3698745623L, "Hilo4");
		HiloCalculoPrimo hcp5 = new HiloCalculoPrimo(111111181111111L, "Hilo5");
		
		Thread t1 = new Thread(hcp1);
		Thread t2 = new Thread(hcp2);
		Thread t3 = new Thread(hcp3);
		Thread t4 = new Thread(hcp4);
		Thread t5 = new Thread(hcp5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
