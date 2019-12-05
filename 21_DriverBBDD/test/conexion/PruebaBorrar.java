package conexion;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaBorrar {

	public static void main(String[] args) {
		
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexión establecida");
			
			Coche coche = null;

			int id = 2;
			coche = daoCoche.obtener(id);
			if (coche != null) {
				daoCoche.borrar(coche);
				System.out.println("Se ha borrado el coche: " + coche);
			} else {
				System.out.println("No existe un coche de identidad: " + id);
			}
			
		} else {
			System.out.println("fallo de conexión");
		}

	}

}
