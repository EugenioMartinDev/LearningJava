package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import utils.Constantes;

public class ServidorCalculadora {

	private String Calcula(String operacion, int iNumero1, int iNumero2) {
		
		double resultado = 0.0;
		String sResultado = "";
		
		if (Constantes.SUMA.contentEquals(operacion) ) {			
			resultado = iNumero1 + iNumero2;
		}		
		if (Constantes.RESTA.contentEquals(operacion) ) {			
			resultado = iNumero1 - iNumero2;
		}
		if (Constantes.MULTIPLICACION.contentEquals(operacion) ) {			
			resultado = iNumero1 * iNumero2;
		}
		if (Constantes.DIVISION.contentEquals(operacion) ) {
			try {
			resultado = (double)iNumero1 / (double)iNumero2;
			} catch (Exception ex) {
				sResultado = ex.getMessage().toString();
			}
			
		}
		if (Constantes.RESTO.contentEquals(operacion) ) {			
			try {
				resultado = iNumero1 % iNumero2;
			} catch (Exception ex) {
				sResultado = ex.getMessage().toString();
			}
		}
		if (Constantes.POTENCIA.contentEquals(operacion) ) {			
			resultado = Math.pow(iNumero1,iNumero2);
		}
		if (Constantes.RAIZ.contentEquals(operacion) ) {			
			resultado = Math.pow(iNumero1, 1.0/iNumero2);
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
				
				PrintStream ps = new PrintStream(socket.getOutputStream());
				String resultado = "";
				if (errorEnRecepcion.isEmpty())
				{
					System.out.println(numero1 + " " + numero2);
					int iNumero1 = Integer.parseInt(numero1);
					int iNumero2 = Integer.parseInt(numero2);
					
					resultado = servidorCalculadora.Calcula(operacion, iNumero1, iNumero2);					 
					ps.println(resultado);
				} else ps.println(resultado);

				System.out.println("Fin del servidor");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException nfe) {
				System.out.println("No es un numero lo que has mandado");
			}
		}
	}


		



}
