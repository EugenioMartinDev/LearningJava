package conexion;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaObtener {

	public static void main(String[] args) {
		
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexión establecida");
			
			int id = 1;

			Coche coche = daoCoche.obtener(id);
			
			if (coche != null ) { 		
				System.out.println(coche);
			} else {
				System.out.println("No se encontrado el coche de identidad: " + id);
			}
			
		} else {
			System.out.println("fallo de conexión");
		}

	}

}
