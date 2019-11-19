package ejercicios;
import java.util.Scanner;

public class Ejercicio06AlrededorSexto {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		
		char sexo = 'H';
		
		if (sexo == 'H')
			System.out.println("Hombre");
		else
			System.out.println("Mujer");
		
		String sexoS = "Hombre";
		
		if (sexoS.equals("Hombre"))
			System.out.println("Hombre String");
		else
			System.out.println("Mujer String");
		
		char sexoLeer;
		
		System.out.println("Teclear sexo (H/M) : ");
		
		sexoLeer = leer.next().charAt(0);
		
		if (sexoLeer == 'H')
			System.out.println("Hombre Char");
		else
			System.out.println("Mujer Char");
		
		String sexoLeerS;
		
		System.out.println("Teclear sexo String (Hombre/Mujer) : ");
		sexoLeerS = leer.next();
		
		if (sexoLeerS == "Hombre")
				System.out.println("Hombre leído String");
			else
				System.out.println("Mujer leído String");
		
		String cad1 = new String("asdf");
		String cad2 = new String("asdf");
		if (cad1.contentEquals(cad2))
			System.out.println("cad1 y cad2 son iguales");
		else
			System.out.println("cad1 y cad2 son diferentes");
		
		cad2 = null;
		if (cad1.equals(cad2))
			System.out.println("cad1 y cad2 son iguales");
		else
			System.out.println("cad1 y cad2 son diferentes");
		
		leer.close();
		
	}

}
