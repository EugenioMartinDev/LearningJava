package conexion;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaModificar {

	public static void main(String[] args) {
		
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexión establecida");
			
			Coche coche = new Coche();
			
			coche.setId(1);
			coche.setMatricula("12344hh");
			coche.setMarca("AlfaRomeo");
			coche.setModelo("600");
			
			if (daoCoche.modificar(coche)) {
				System.out.println("Modificado");
			} else {
				System.out.println("Error : falla modificación");
			};
			
		} else {
			System.out.println("fallo de conexión");
		}

	}

}
