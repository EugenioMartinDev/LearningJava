package conexion;

import java.util.ArrayList;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaListar {

	public static void main(String[] args) {
		
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexi�n establecida");
			
			ArrayList<Coche> listaCoches = (ArrayList) daoCoche.listar();
			
			if (listaCoches.size() > 0) {
			for (Coche coche : listaCoches) {
				System.out.println(coche);
			}
			} else
			{
				System.out.println("No se ha encontrado ning�n coche");
			}
			
		} else {
			System.out.println("fallo de conexi�n");
		}

	}

}
