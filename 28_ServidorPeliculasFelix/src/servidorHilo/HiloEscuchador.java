package servidorHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class HiloEscuchador implements Runnable{
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeAlCliente;
	private GestorPeliculas gp;
	
	
	public HiloEscuchador(Socket cliente, GestorPeliculas gp) {
		numCliente++;
		hilo = new Thread(this, "Cliente_"+numCliente);
		this.enchufeAlCliente = cliente;
		this.gp = gp;
		hilo.start();
	}
	
	@Override
	public void run() {
		System.out.println("Estableciendo comunicación con " + hilo.getName());
		try {
			InputStream entrada = enchufeAlCliente.getInputStream();
			OutputStream salida = enchufeAlCliente.getOutputStream();
			String texto = "";
			
			InputStreamReader isr = new InputStreamReader(entrada);

			// para leer por frases, podemos usar la siguiente clase
			BufferedReader bf = new BufferedReader(isr);
			String cadena = bf.readLine();
			System.out.println("Ha llegado lo siguiente al servidor: " + cadena);
			//23-34-1
			String[] cadenaDividida = cadena.split("-");
			String operacion = cadenaDividida[0];
			
			if(operacion.equals("1")) {//alta
				String id = cadenaDividida[1];
				String titulo = cadenaDividida[2];
				String director = cadenaDividida[3];
				
				Pelicula p = new Pelicula();
				p.setId(id);
				p.setDirector(director);
				p.setTitulo(titulo);
				
				gp.alta(p);
			}else if (operacion.equals("2")) {//buscar por id
				String id = cadenaDividida[1];
				Pelicula p = gp.buscar(id);
				String resultado = "";
				if(p == null) {
					p = new Pelicula();
				}
				
				resultado = p.getId() + "-" + p.getTitulo()
					+ "-" + p.getDirector();
				
				PrintStream ps = new PrintStream(salida);
				ps.println(resultado);
			}else if (operacion.equals("3")) {//baja por id
				String id = cadenaDividida[1];
				int resultado = gp.baja(id);
				
				PrintStream ps = new PrintStream(salida);
				ps.println(resultado);
			}

			entrada.close();
			salida.close();
			enchufeAlCliente.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}