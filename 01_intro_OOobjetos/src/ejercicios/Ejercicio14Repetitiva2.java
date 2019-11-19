package ejercicios;

public class Ejercicio14Repetitiva2 
{

	public static void main(String[] args) 
	{
		
		final int LIMITE = 10000000;
		
		long mult3y7=0, mult3=0, mult7=0;
		
		System.out.println("Valor múltiplo de 3 y 7 : ");
		for (long i=1; i<=LIMITE; i++)
		{
			if (i%3 != 0 && i%7 != 0)
				continue;
			
			if (i%3 == 0 && i%7 == 0)
			{
				mult3++;
				mult7++;
				mult3y7++;
				System.out.print(i+ " ");
				if (mult3y7%10000 == 0)
					System.out.println();
			}else
				if (i%3 == 0)
					mult3++;
				else
					mult7++;

		}		
		System.out.println();
		System.out.println("Múltiplos de 3 : " + mult3);
		System.out.println("Múltiplos de 7 : " + mult7);
		System.out.println("Múltiplos de 3 y 7 : " + mult3y7);
		System.out.println("Múltiplos de ninguno : " + (LIMITE-mult3-mult7+mult3y7));		
	}


}
