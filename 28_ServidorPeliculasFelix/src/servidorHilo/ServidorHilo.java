package servidorHilo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServidorHilo {
	public static void main(String[] args) {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("localhost",2020);
			servidor.bind(direccion);

			System.out.println("Servidor creado");
			System.out.println("Dirección IP: " + direccion.getAddress());
			
			//Creas el treemap y lo rellenas con los datos
			//El objeto gestor debe de ser unico porque solo tiene
			//que haber una lista para toda la aplicacion
			GestorPeliculas gp = new GestorPeliculas(new ArrayList<Pelicula>());
			
			//fin de crear el treemap
			while (true) {
				//esperamos a que llegue un cliente
				Socket enchufeAlCliente = servidor.accept();
				System.out.println("Comunicación entrante");
				new HiloEscuchador(enchufeAlCliente, gp);//abrimos un hilo nuevo y liberamos el hilo principal
				//En vez de uno, le pasaremos tambien el treemap
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}