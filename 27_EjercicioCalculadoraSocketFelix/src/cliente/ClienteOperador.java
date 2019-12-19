package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteOperador {
	
	public static Scanner sc = null;


	private String menuOperaciones() {
		
		String operacion = "";
		
		System.out.println("************ OPERACIONES " );
		System.out.println("1- SUMA");
		System.out.println("2- RESTA");
		System.out.println("3- MULTIPLICACION");
		System.out.println("4- DIVISION");

		operacion = sc.nextLine();
		
		return operacion;
	}
	
	
	public static void main(String[] args) {
		
		ClienteOperador clienteOperador = new ClienteOperador();
		
		sc = new Scanner(System.in);
		
		String operacion = clienteOperador.menuOperaciones();

			try ( Socket socket = new Socket("127.0.0.1", 2019);
				  PrintStream ps = new PrintStream(socket.getOutputStream()); )
			{	
				
				String numero1 = "", numero2 = "";
				System.out.println("Introduzca el numero1 :");
				operacion = sc.nextLine();
				System.out.println("Introduzca el numero2 :");
				operacion = sc.nextLine();
				
				ps.println(operacion + "-" + numero1 + "-" + numero2);
				
				//ps.println("28" + "-" + "79" + "-" + "sumar");	

				InputStreamReader isr = new InputStreamReader(socket.getInputStream());				
				BufferedReader bf = new BufferedReader(isr);
				
				String cadena = bf.readLine();
				
				System.out.println("El resultado es = " + cadena);
				
				System.out.println("Fin del cliente");
				
			} catch (UnknownHostException ex) {
				ex.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
						
	}




}
