package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import utils.Constantes;

public class ClienteOperador {
	
	public static Scanner sc = null;


	private String menuOperaciones() {
		
		String operacion = "";
		
		System.out.println("************ OPERACIONES " );
		System.out.println("1- SUMA");
		System.out.println("2- RESTA");
		System.out.println("3- MULTIPLICACION");
		System.out.println("4- DIVISION");
		System.out.println("5- RESTO");
		System.out.println("6- POTENCIA");
		System.out.println("7- RAIZ");
		operacion = sc.nextLine();
		
		return operacion;
	}
	
	private void enviarOperacion(String operacion, PrintStream ps) {
		
		int numero1 = 0, numero2 = 0;
		
		switch (operacion) {
			
			case (Constantes.SUMA):
				System.out.println("Introduzca el primer sumando : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca el segundo sumando : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);
				break;
			case (Constantes.RESTA):
				System.out.println("Introduzca el minuendo : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca el sustraendo : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);
				break;
			case (Constantes.MULTIPLICACION):
				System.out.println("Introduzca el multiplicando : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca el multiplicador : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);
				break;
			case (Constantes.DIVISION):
				System.out.println("Introduzca el dividendo : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca el divisor : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);
				break;
			case (Constantes.POTENCIA):
				System.out.println("Introduzca la base : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca exponente : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);	
				break;
			case (Constantes.RAIZ):
				System.out.println("Introduzca la base : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca el exponente de la raíz : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);
				break;
			case (Constantes.RESTO):
				System.out.println("Introduzca el dividendo : ");
				numero1 = sc.nextInt();
				System.out.println("Introduzca el divisor : ");
				numero2 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1 + "/" + numero2);	
				break;
			case (Constantes.ABSOLUTO):
				System.out.println("Introduzca el valor : ");
				numero1 = sc.nextInt();
				
				ps.println(operacion + "-" + numero1);	
				break;
			default:
				
		}
						
	}
	
	public static void main(String[] args) {
		
		ClienteOperador clienteOperador = new ClienteOperador();
		
		sc = new Scanner(System.in);
		
		String operacion = clienteOperador.menuOperaciones();

			try ( Socket socket = new Socket("127.0.0.1", 2019);
				  PrintStream ps = new PrintStream(socket.getOutputStream()); )
			{	
				
				clienteOperador.enviarOperacion(operacion, ps);
				
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
