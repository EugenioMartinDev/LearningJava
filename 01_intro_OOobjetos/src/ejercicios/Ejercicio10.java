package ejercicios;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		/*
		 * 10.	Pedimos por pantalla un nombre y una contraseña:
				a.	si el nombre coincide con “sara”, preguntamos por  la contraseña y si coincide con “sarita”, 
				    escribimos el mensaje “usuario y contraseña correctas, bienvenido a la aplicación”
				b.	Si el nombre NO es “sara” Escribimos usuario incorrecto”
				c.	Si el nombre es correcto y la contraseña NO, Escribimos “contraseña incorrecta”
		 */

		final String NOMBRESARA = "sara";
		final String CONTRASEÑASARITA = "sarita";
		
		String nombre = "";
		String contraseña = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del usuario : ");
		nombre = sc.next();
		
		if (nombre.equals(NOMBRESARA))
		{
			System.out.println("Introduce la contraseña del usuario " + " nombre " + ": ");
			contraseña = sc.next();
			
			if (contraseña.equals(CONTRASEÑASARITA)) {
				System.out.println("Usuario y contraseña correctas, bienvenido a la aplicación");
			}
			else
			{
				System.out.println("Contraseña incorrecta");
			}
			
		}
		else
		{
			System.out.println("Introduce la contraseña del usuario " + nombre + ": ");
			contraseña = sc.next();
			
			if (!contraseña.equals(CONTRASEÑASARITA)) {
				System.out.println("Usuario y cotraseña incorrecta");
			}
			else
			{
				System.out.println("Usuario incorrecto");
			}
			
		}
		
		sc.close();
		
	}

}
