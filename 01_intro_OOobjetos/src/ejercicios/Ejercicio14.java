package ejercicios;
import java.util.Scanner;

public class Ejercicio14 {
	
	class Billete {
		
		int tipoBillete = 0;
		public Billete nextBillete;
		
		Billete(int tipoBill)
		{
			tipoBillete = tipoBill;
		}
		
		public void link(Billete nextBill)
		{
			this.nextBillete = nextBill;
		}
		
		public void calcular(double cantidad)
		{
			double queda = cantidad;
			if (queda >= tipoBillete)
			{
				double devolver = Math.floor(queda/tipoBillete);
				queda =  queda%tipoBillete;
				if (devolver > 1)
					System.out.print((int) devolver + " billetes de " + tipoBillete + "€ ");
				else
					System.out.print((int) devolver + " billete de "+ tipoBillete + "€ ");
			}
			
			if (queda > 0)
			{
				this.nextBillete.calcular(queda);
			}
		}

	}

	private  double billetaje(final int tipoBillete, double cantidad)
	{
		double queda = cantidad;
		if (queda >= tipoBillete)
		{
			double devolver = Math.floor(queda/tipoBillete);
			queda =  queda%tipoBillete;
			if (devolver > 1)
				System.out.println("Devuelvo " + (int) devolver + " billetes de " + tipoBillete + " €");
			else
				System.out.println("Devuelvo " + (int) devolver + " billete de "+ tipoBillete + " €");
		}
		
		return queda;
	}

	public static void main(String[] args) {

/*
 * 
 * 3.	Vamos a simular un cajero de un super. Para hacer fácil, vamos a trabajar solo con billetes de 50€, 20€, 10€, 5€, sin monedas. 
 *      Por tanto el importe será siempre múltiplo de 5.
		a.	Solicitamos el importe de la venta(múltiplo de 5), y con cuanto me paga(igual o mayor al importe de la venta(múltiplo de 5).
		b.	El programa informa, cuantos billetes le tengo que devolver.
		c.	Por ejemplo:
			o	Importe venta 15, pagado 50. La salida será: 1 de 20, 1 de 10 y 1 de 5.
			o	Importe venta 25, pagado 200: 3 de 50, 1 de 20  y 1 de 5.
		d.	Suponemos que siempre tengo suficientes billetes de 50, de 20 , de 10 y de 5 euros.

 * 
 */
		
		Ejercicio14 exercise = new Ejercicio14();
		
		final int BILLETE5 = 5;
		final int BILLETE10 = 10;
		final int BILLETE20 = 20;
		final int BILLETE50 = 50;
		
		double pago = 0;
		
		double venta = Math.round(Math.random()*1000)*5;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("El coste es : " + (int) venta + " €");
		
		System.out.println("Introduce el importe del pago : ");
		pago = sc.nextDouble();
		
		sc.close();
		
		if (
				(pago == 0)
				||
				(pago % 5 != 0)
				||
				(pago < venta)
			)
		{
			System.out.println("No se puede proceder a la venta");
		}
		else
		{
			
			double queda = pago - venta;	
			System.out.println("Hay que devolver  " + (int) queda + " €");
			
			Billete bill50 = exercise.new Billete(BILLETE50);
			Billete bill20 = exercise.new Billete(BILLETE20);
			Billete bill10 = exercise.new Billete(BILLETE10);
			Billete bill5 = exercise.new Billete(BILLETE5);
			
			bill50.nextBillete = bill20;
			bill20.nextBillete = bill10;
			bill10.nextBillete = bill5;
			
			System.out.print("Devuelvo ");
			
			if (queda == 0)
			{
				System.out.println(" nada");
			}
			else			
				bill50.calcular(queda);
			
			/*
			queda = exercise.billetaje(BILLETE50, queda);
			queda = exercise.billetaje(BILLETE20, queda);
			queda = exercise.billetaje(BILLETE10, queda);
			queda = exercise.billetaje(BILLETE5, queda);
			*/
			
			/*
			
			if (queda >= BILLETE50)
			{
				double devolver = Math.floor(queda/BILLETE50);
				queda =  queda%BILLETE50;
				if (devolver > 1)
					System.out.println("Devuelvo " + (int) devolver + " billetes de 50 €");
				else
					System.out.println("Devuelvo " + (int) devolver + " billete de 50 €");
			}
			
			if (queda >= BILLETE20)
			{
				double devolver = Math.floor(queda/BILLETE20);
				queda =  queda%BILLETE20;
				if (devolver > 1)
					System.out.println("Devuelvo " + (int) devolver + " billetes de 20 €");
				else
					System.out.println("Devuelvo " + (int) devolver + " billete de 20 €");	
			}
			

			if (queda >= BILLETE10)
			{
				double devolver = Math.floor(queda/BILLETE10);
				queda =  queda%BILLETE10;
				if (devolver > 1)
					System.out.println("Devuelvo " + (int) devolver + " billetes de 10 €");
				else
					System.out.println("Devuelvo " + (int) devolver + " billete de 10 €");
			}
			
			if (queda >= BILLETE5)
			{
				double devolver = Math.floor(queda/BILLETE5);
				queda =  queda%BILLETE5;
				if (devolver > 1)
					System.out.println("Devuelvo " + (int) devolver + " billetes de 5 €");
				else
					System.out.println("Devuelvo " + (int) devolver + " billete de 5 €");
			}
			
			*/
			
		}

	}

}
