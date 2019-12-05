package conexion;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaBorrar {

	public static void main(String[] args) {
		
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexión establecida");
			
			Coche coche = new Coche();
			
			coche.setId(6);
			daoCoche.borrar(coche);
			
		} else {
			System.out.println("fallo de conexión");
		}

	}

}
