package cliente.modelo.persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import cliente.modelo.entidad.Pelicula;

public class DaoClientePelicula {

	public void socketAlta(String id, String titulo, String director) {
		
		
		try(Socket socket = new Socket("127.0.0.1",2020);
				PrintStream ps = 
						new PrintStream(socket.getOutputStream())) {
	
			ps.println("1-" + id + "-" + titulo + "-" + director);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pelicula socketBusquedaId(String id) {
		
		
		try(Socket socket = new Socket("127.0.0.1",2020);
				PrintStream ps = 
						new PrintStream(socket.getOutputStream())) {
	
			ps.println("2-" + id);
			
		
			InputStreamReader isr = 
					new InputStreamReader(socket.getInputStream());
			
			
			BufferedReader bf = new BufferedReader(isr);
		
			String cadena = bf.readLine();
			String[] cadenaDividida = cadena.split("-");
			Pelicula pelicula = new Pelicula();
			pelicula.setId(cadenaDividida[0]);
			pelicula.setTitulo(cadenaDividida[1]);
			pelicula.setDirector(cadenaDividida[2]);
			
			return pelicula;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public int socketBorrarId(String id) {
		
		
		try(Socket socket = new Socket("127.0.0.1",2020);
				PrintStream ps = 
						new PrintStream(socket.getOutputStream())) {
	
			ps.println("3-" + id);
			
		
			InputStreamReader isr = 
					new InputStreamReader(socket.getInputStream());
			
			
			BufferedReader bf = new BufferedReader(isr);
		
			String cadena = bf.readLine();
			
			int resultado = Integer.parseInt(cadena);
			
			return resultado;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 1;
	}
}


