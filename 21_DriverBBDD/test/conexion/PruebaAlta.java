package conexion;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaAlta {

	public static void main(String[] args) {
		
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexión establecida");
			
			Coche coche = new Coche();
			
			coche.setMatricula("9999HJJ");
			coche.setMarca("Ferrari");
			coche.setModelo("TORORROSO");
			
			if (daoCoche.alta(coche)) {
				System.out.println("Dado de alta");
			} else {
				System.out.println("Error : falla el alta");
			};
			
		} else {
			System.out.println("fallo de conexión");
		}
			
		
		
	}

}
