package ejercicios;

public class Ejercicio13Repetitiva2 {

	public static void main(String[] args) {
		
		for (int i=1; i<=250; i++)
		{
			if (i%5==0 && i%7==0)
			{
				System.out.println("El valor " + i + " es múltiplo de 5 y 7");
			}
		}

	}

}
