package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.entidad.Coche;
import modelo.negocio.GestorLibreriaPersistente;
import modelo.persistencia.DaoLibreria;
import servidor.modelo.negocio.GestorRepositorioCoches;
import servidor.modelo.persistencia.DaoCoche;


public class ServidorRepositorioCoches {
	
	/**
	 *  Dar de alta los datos de un coche en un servidor. El cliente envía los datos del coche al servidor.
	 *  El servidor almacena esos datos, muestra en consola TODOS los coches de alta y devuelve indicación 
	 *  al cliente de si se ha podido o no dar de alta.
	 */


	private String compruebaInfoRecibida(String cadena) {
		
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
		
		ServidorRepositorioCoches servidorRepositorioCoches = new ServidorRepositorioCoches();
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(2019);
			System.out.println("Server escuchando por el puerto 2019");
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
		GestorRepositorioCoches gl = new GestorRepositorioCoches();
		DaoCoche daoCoche = new DaoCoche();
		gl.setDaoCoche(daoCoche);

		while (true) {
			System.out.println("Escuchando peticiones...");
			try (Socket socket = ss.accept();) {

				System.out.println(socket.getInetAddress().getHostAddress());
				
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());

				BufferedReader bf = new BufferedReader(isr);
				String cadena = bf.readLine();
				System.out.println("Ha llegado información : " + "\"" + cadena + "\"" + " al servidor");
				
				String errorEnInfo = servidorRepositorioCoches.compruebaInfoRecibida(cadena);
				PrintStream ps = new PrintStream(socket.getOutputStream());
				String resultado = "";
								
				if (errorEnInfo.isEmpty())
				{			
					String[] datosCoche = cadena.split("-");

					System.out.println("Se ha pedido el alta del coche ");
					System.out.println("con matrícula : " + datosCoche[0] + " y marca : " + datosCoche[1] + " y modelo : " + datosCoche[2]);
					
					Coche coche = new Coche();
					coche.setMatricula(datosCoche[0]);
					coche.setModelo(datosCoche[1]);
					coche.setMarca(datosCoche[2]);
					
					resultado = gl.alta(coche);					 
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
