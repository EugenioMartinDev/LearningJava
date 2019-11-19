package ejercicios;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		double num1 = 1.8e25;
		int num2 = 0;
		
		//reading simulation
		num1 = 15.8;
		num2 = 25;
		
		//proceso
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));

		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));

		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));

		System.out.println(num1 + " % " + num2 + " = " +  (num1 % num2));
		
		System.out.println(num1 + " / " + num2 + " = " +  (num1 / num2));
		
		
		int resultado = 0;
		resultado = (int)num1 * num2;
		System.out.println("resultado de casting en primer operador " + resultado);
				//error type mismatch
		resultado = (int)(num1 * num2);
		System.out.println("resultado de casting en mult " + resultado);
		

	}

}
