package modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import modelo.entidad.Login;

public class GestorLogin {

	private Map<String, String> mapaContraseñas; 
	
	public boolean validar(Login login) {
		
		initMapaContraseñas();
		
		try {
			if(login.getUsuario().isEmpty()) {
				return false;
			}
			if(login.getContraseña().isEmpty()) {
				return false;
			}
			if (mapaContraseñas.get(login.getUsuario()) == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initMapaContraseñas() {
		
		mapaContraseñas = new HashMap<String, String>();
		
		mapaContraseñas.put("Jose", "1234");
		mapaContraseñas.put("Juan", "1234");
		mapaContraseñas.put("Pablo", "1234");
		
	}

}
