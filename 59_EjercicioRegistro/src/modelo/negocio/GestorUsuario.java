package modelo.negocio;

import modelo.entidad.Usuario;

public class GestorUsuario {

	public boolean validar(Usuario usuario) {
		if(usuario.getNombre().equals("bud")
				&& usuario.getPassword().equals("1234")) {
			return true;
		}
		
		return false;
	}

}
