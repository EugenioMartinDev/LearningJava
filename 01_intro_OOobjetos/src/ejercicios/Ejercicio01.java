package ejercicios;
public class Ejercicio01 {

	public static void main(String[] args) {
		
		/*
		String nombre = "Seb{eéastián";
		
		System.out.println(nombre.toUpperCase());
		
		System.out.println(String.valueOf(1234).substring(1, 3));
		
		*/
		
		int num1 = 0, num2 = 0;
		
		//simulamos que lo leemos
		num1 = 15;
		num2 = 25;
		
		//proceso
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));

		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));

		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));

		System.out.println(num1 + " % " + num2 + " = " +  (num1 % num2));
		
		System.out.println(num1 + " / " + num2 + " = " +  (num1 / num2));
	}

}
