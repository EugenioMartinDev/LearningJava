package modelo.negocio;

import modelo.entidad.Persona;

public class GestorPersona {
	
	public boolean validar(Persona p) {
		if(p.getNombre().isEmpty() || p.getApellidos().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}
