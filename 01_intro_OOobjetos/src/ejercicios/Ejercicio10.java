package ejercicios;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		/*
		 * 10.	Pedimos por pantalla un nombre y una contrase�a:
				a.	si el nombre coincide con �sara�, preguntamos por  la contrase�a y si coincide con �sarita�, 
				    escribimos el mensaje �usuario y contrase�a correctas, bienvenido a la aplicaci�n�
				b.	Si el nombre NO es �sara� Escribimos usuario incorrecto�
				c.	Si el nombre es correcto y la contrase�a NO, Escribimos �contrase�a incorrecta�
		 */

		final String NOMBRESARA = "sara";
		final String CONTRASE�ASARITA = "sarita";
		
		String nombre = "";
		String contrase�a = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del usuario : ");
		nombre = sc.next();
		
		if (nombre.equals(NOMBRESARA))
		{
			System.out.println("Introduce la contrase�a del usuario " + " nombre " + ": ");
			contrase�a = sc.next();
			
			if (contrase�a.equals(CONTRASE�ASARITA)) {
				System.out.println("Usuario y contrase�a correctas, bienvenido a la aplicaci�n");
			}
			else
			{
				System.out.println("Contrase�a incorrecta");
			}
			
		}
		else
		{
			System.out.println("Introduce la contrase�a del usuario " + nombre + ": ");
			contrase�a = sc.next();
			
			if (!contrase�a.equals(CONTRASE�ASARITA)) {
				System.out.println("Usuario y cotrase�a incorrecta");
			}
			else
			{
				System.out.println("Usuario incorrecto");
			}
			
		}
		
		sc.close();
		
	}

}
