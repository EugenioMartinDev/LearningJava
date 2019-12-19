package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorCalculadora {

	private String Calcula(int iOperacion, int iNumero1, int iNumero2) {
		
		double resultado = 0.0;
		String sResultado = "";
		
		switch (iOperacion) {
		
		case 1:
			resultado = iNumero1 + iNumero2;
			break;
		case 2:
			resultado = iNumero1 - iNumero2;
			break;
		case 3:
			resultado = iNumero1 * iNumero2;
			break;
		case 4:
			try {
			resultado = iNumero1 / iNumero2;
			} catch (ArithmeticException e) {
				resultado = 0;
				sResultado = "No admito divisores entre 0";
			}
			break;
		
		}
		
			
		if (sResultado.isEmpty() )
			return String.valueOf(resultado);
		else return sResultado;
		
	}
	
	private String compruebaInfoRecibida(String cadena, String operacion, String numero1, String numero2) {
		
		String errorEnRecepcion = "";
		
		String[] infoRecibida = cadena.split("-");
		
		if (infoRecibida[0] == null) errorEnRecepcion = "No se ha introducido ninguna operación";
		else operacion = infoRecibida[0];
		
		if (infoRecibida[1] != null) {
			String[] numeros = infoRecibida[1].split("/");	
			if (numeros[0] == null || numeros[1] == null) errorEnRecepcion = "Falta un número";
			else {
				numero1 = numeros[0];
				numero2 = numeros[1];
			}
		} else errorEnRecepcion = "No se han recibido los números";
		
		return errorEnRecepcion;
		
	}
	
	public static void main(String[] args) {
		
		ServidorCalculadora servidorCalculadora = new ServidorCalculadora();
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(2019);
			System.out.println("Server escuchando por el puerto 2019");
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		while (true) {
			System.out.println("Escuchando peticiones...");
			try (Socket socket = ss.accept();) {

				System.out.println(socket.getInetAddress().getHostAddress());
				
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());

				BufferedReader bf = new BufferedReader(isr);
				String cadena = bf.readLine();
				System.out.println("Ha llegado información : " + "\"" + cadena + "\"" + " al servidor");
				
				String operacion = "", numero1 = "", numero2 = "";
				//String errorEnInfo = servidorCalculadora.compruebaInfoRecibida(cadena, operacion, numero1, numero2);
					
				PrintStream ps = new PrintStream(socket.getOutputStream());
				
				String[] infoRecibida = cadena.split("-");
		

				numero1 = infoRecibida[0];
				numero2 = infoRecibida[1];
				operacion = infoRecibida[2];

				
				
				String resultado = "";

					System.out.println(numero1 + " " + numero2);
					int iNumero1 = Integer.parseInt(numero1);
					int iNumero2 = Integer.parseInt(numero2);
					int iOperacion = Integer.parseInt(operacion);
					
					resultado = servidorCalculadora.Calcula(iOperacion, iNumero1, iNumero2);					 
					ps.println(resultado);


				System.out.println("Fin del servidor");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException nfe) {
				System.out.println("No es un numero lo que has mandado");
			}
		}
	}


		



}
