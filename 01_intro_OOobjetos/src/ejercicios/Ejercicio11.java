package ejercicios;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		/*
		 * 
		 * 11.	Tenemos una variable llamado opci�n, si contiene:
				a.	�validar" leer dos variables, el usuario y password, y comparamos ,
				 		si usuario es "sara" y password es "sarita" Escribimos "Bienvenido" ; 
				 		si no hay coincidencia Escribimos "Lo sentimos"
				b.	�registrar",  Escribimos "estamos registrando"
				c.	�cerrar sesi�n�: Escribir �cerrando sesi�n�
				d.	cualquier otra opci�n ponemos "opci�n err�nea"

		 */		
		
		String opcion = "validar";
		//opcion = "registrar";
		
		switch(opcion){
		
		case "validar":
			Scanner sc = new Scanner(System.in);
			
			String usuario = "";
			String contrase�a = "";
			
			System.out.println("Introduce usuario : ");
			usuario = sc.next();
			System.out.println("Introduce contrase�a : ");
			contrase�a = sc.next();
			
			boolean userFound = false;
			
			if (usuario.equals("sara"))
			{
				if (contrase�a.equals("sarita"))
				{
					userFound = true;
				}
			}
			
			if (userFound) 
				System.out.println("Bienvenido");
			else
				System.out.println("Lo sentimos");
			
			sc.close();
			
			break;
		
		case "registrar":
			
			System.out.println("Estamos registrando");
			break;
		
		case "cerrar sesion":
			System.out.println("Cerrando sesi�n");
			break;
		
		default:
			System.out.println("Opci�n err�nea");
			
		
		}
		
	}

}
