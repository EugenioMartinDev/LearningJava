package modelo.negocio;

import modelo.entidad.Persona;

public class GestorPersonas {

	public boolean validar(Persona persona) {
		
		if (persona.getNombre().isEmpty() || persona.getApellidos().isEmpty()) {
			return false;
		}  
		
		return true;
	}
	
}
