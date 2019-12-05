package conexion;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCoche;

public class PruebaConexion {

	public static void main(String[] args) {
		DaoCoche daoCoche = new DaoCoche();
		
		if (daoCoche.abrirConexion()) {
			System.out.println("conexión establecida");
		} else {
			System.out.println("fallo de conexión");
		}
			
		
		/*
		Coche coche = new Coche();
		
		coche.setMatricula("1234HJJ");
		coche.setMarca("Ferrari");
		coche.setModelo("TORORROSO");
		
		daoCoche.alta(coche);
		
		
		coche.setId(3);
		daoCoche.borrar(coche);
		
		daoCoche.listar();
		
		*/
		
		
				

	}

}
