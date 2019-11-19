package ejercicios;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		/*
		 * 
		 * 11.	Tenemos una variable llamado opción, si contiene:
				a.	“validar" leer dos variables, el usuario y password, y comparamos ,
				 		si usuario es "sara" y password es "sarita" Escribimos "Bienvenido" ; 
				 		si no hay coincidencia Escribimos "Lo sentimos"
				b.	“registrar",  Escribimos "estamos registrando"
				c.	“cerrar sesión”: Escribir “cerrando sesión”
				d.	cualquier otra opción ponemos "opción errónea"

		 */		
		
		String opcion = "validar";
		//opcion = "registrar";
		
		switch(opcion){
		
		case "validar":
			Scanner sc = new Scanner(System.in);
			
			String usuario = "";
			String contraseña = "";
			
			System.out.println("Introduce usuario : ");
			usuario = sc.next();
			System.out.println("Introduce contraseña : ");
			contraseña = sc.next();
			
			boolean userFound = false;
			
			if (usuario.equals("sara"))
			{
				if (contraseña.equals("sarita"))
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
			System.out.println("Cerrando sesión");
			break;
		
		default:
			System.out.println("Opción errónea");
			
		
		}
		
	}

}
