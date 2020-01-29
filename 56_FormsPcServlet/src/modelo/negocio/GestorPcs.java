package modelo.negocio;

import modelo.entidad.Pc;

public class GestorPcs {

	public boolean Validar(Pc pc) {

		if (pc.getDevices() == null || pc.getDevices().length == 0 || pc.getModelo().isEmpty()) {
			return false;
		}
	
		return true;
	}
	
}
