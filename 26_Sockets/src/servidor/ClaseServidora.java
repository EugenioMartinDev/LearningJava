package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClaseServidora {

	public static void main(String[] args) {
		
		System.out.println("Escuchando peticiones por el puerto 2019 ....");
		try (ServerSocket ss = new ServerSocket(2019);){
			while (true)
			{
			try ( 
				Socket socket = ss.accept(); )
				{
					//Abrimos el puerto y escuchamos peticiones del socket entrante : ServerSocket(2019)
				
					//El método accept deja parado el hilo de ejecución hasta que 
					//la petición de conexión del cliente llegue : ss.accept()
					
					//InputStreamReader lee del tunel de entrada de datos.Sólo lee caracteres.			
					InputStreamReader isr = new InputStreamReader(socket.getInputStream());
					
					//Para leer por palabras, usamos BufferedReader
					BufferedReader bf = new BufferedReader(isr);
					
					String cadena = bf.readLine();
					System.out.println("Ha llegado información : " + "\"" + cadena + "\"" + " al servidor");
					
					String[] numeros = cadena.split("-");
					String numero1 = numeros[0];
					String numero2 = numeros[1];
					
					int iNumero1 = Integer.parseInt(numero1);
					int iNumero2 = Integer.parseInt(numero2);
					
					int resultado = iNumero1 + iNumero2;
					
					PrintStream ps = new PrintStream(socket.getOutputStream()); 
					ps.println(resultado);
					
					System.out.println("Fin del servidor");
								
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
