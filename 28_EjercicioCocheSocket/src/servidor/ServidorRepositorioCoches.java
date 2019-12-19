package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.entidad.Coche;
import servidor.modelo.negocio.GestorRepositorioCoches;
import servidor.modelo.persistencia.DaoCoche;
import utils.Constantes;


public class ServidorRepositorioCoches {
	
	/**
	 *  Dar de alta los datos de un coche en un servidor. El cliente envía los datos del coche al servidor.
	 *  El servidor almacena esos datos, muestra en consola TODOS los coches de alta y devuelve indicación 
	 *  al cliente de si se ha podido o no dar de alta.
	 */

	
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

		boolean serverLoop = true;
		
		while (serverLoop) {
			System.out.println("Escuchando peticiones...");
			try (Socket socket = ss.accept();) {

				System.out.println(socket.getInetAddress().getHostAddress());
				
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());

				BufferedReader bf = new BufferedReader(isr);
				String cadena = bf.readLine();
				System.out.println("Ha llegado información : " + "\"" + cadena + "\"" + " al servidor");
				
				PrintStream ps = new PrintStream(socket.getOutputStream());
				String resultado = "";
		
				String[] datosCoche = cadena.split("-");
				
				if (datosCoche.length != 3) ps.println("Hay que introducir tres parámetros : matrícula, marca y modelo");
				else
				{
					System.out.println("Se ha pedido el alta del coche ");
					System.out.println("con matrícula : " + datosCoche[0] + " y marca : " + datosCoche[1] + " y modelo : " + datosCoche[2]);
					
					Coche coche = new Coche();
					coche.setMatricula(datosCoche[0]);
					coche.setMarca(datosCoche[1]);
					coche.setModelo(datosCoche[2]);
					
					int erroresAlta = gl.alta(coche);	
					
					switch (erroresAlta) {
					
					case (Constantes.ERROR_MATRICULA_IS_NULL):
						resultado = "La matrícula no puede ser nula o estar vacía";
						break;
					case (Constantes.ERROR_MARCA_IS_NULL):
						resultado = "La marca no puede ser nula o estar vacía";					
						break;
					case (Constantes.ERROR_MODELO_IS_NULL):
						resultado = "El modelo no puede ser nulo o estar vacía";
						break;
					case (Constantes.ERROR_MATRICULA_IS_DUPLICATED):
						resultado = "La matrícula ya está dada de alta";
						break;
					case (Constantes.ERROR_IN_DDBB):
						resultado = "Se ha producido un error en la base de datos";
						break;
					case (Constantes.SUCCESSFULL_EXECUTION):
						resultado = "Alta realizada con éxito";
											
						for (Coche cocheElemento : gl.listarCoches()) {
							System.out.println(cocheElemento);
						}
						
					
						break;
					default:
						resultado = "Error sin catalogar";
					
					}
					
					ps.println(resultado);
				}

				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException nfe) {
				System.out.println("No es un numero lo que has mandado");
			}
		}
		System.out.println("Fin del servidor");
	}


		



}
