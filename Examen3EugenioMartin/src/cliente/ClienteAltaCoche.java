package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import modelo.entidad.Coche;

public class ClienteAltaCoche {
	
	private Coche coche;
	
	public ClienteAltaCoche (Coche coche) {
		this.coche = coche;
	}
	
	public String pedirAlta()
	{

			String resultado = "El coche ha sido dado de alta";
			try ( Socket socket = new Socket("127.0.0.1", 2019);
				  PrintStream ps = new PrintStream(socket.getOutputStream()); )
			{	
				//Protocolo Matricula - Marca - Modelo
				ps.println(coche.getMatricula() +
						"-" + coche.getMarca() + 
						"-" + coche.getModelo());	

				InputStreamReader isr = new InputStreamReader(socket.getInputStream());				
				BufferedReader bf = new BufferedReader(isr);
				
				resultado = bf.readLine();
				
			} catch (UnknownHostException ex) {
				resultado = ex.getMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				resultado = e.getMessage();
			} finally {
				return resultado;
			}
						
	}




}
