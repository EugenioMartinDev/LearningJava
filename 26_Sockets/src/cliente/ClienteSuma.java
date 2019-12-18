package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteSuma {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca el primer n�mero : ");
		int numero1 = sc.nextInt();
		System.out.println("Introduzca el segundo n�mero : ");
		int numero2 = sc.nextInt();
		
		//Nos conectamos al servidor para enviar los n�meros
		
			// A partir de la versi�n 1.7 de Java, existen los bloques auto-closeables - Los objetos se cierran autom�ticamente
			// No hace falta el bloque finally.
			try ( Socket socket = new Socket("127.0.0.1", 2019);
				  PrintStream ps = new PrintStream(socket.getOutputStream()); )
			{	
				//PrintStream : Clase que extiende de OutputStream. Creamos un objeto que permite escribir sobre la salida del socket.
					
				//ps.println("Hola mundo");
				//Decidimos arbitrariamente el protocolo de env�o y recepci�n.
				ps.println(numero1 + "-" + numero2);
				
				//En el cliente recojemos el resultado
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				
				//Para leer por palabras, usamos BufferedReader
				BufferedReader bf = new BufferedReader(isr);
				
				String cadena = bf.readLine();
				
				System.out.println("El resultado de la suma de " + numero1 + " y " + numero2 + " = " + cadena);
				
				System.out.println("Fin del cliente");
				
			} catch (UnknownHostException ex) {
				ex.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			


	}

}
