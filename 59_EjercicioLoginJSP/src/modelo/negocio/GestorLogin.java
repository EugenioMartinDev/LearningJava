package modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import modelo.entidad.Login;

public class GestorLogin {

	private Map<String, String> mapaContraseņas; 
	
	public boolean validar(Login login) {
		
		initMapaContraseņas();
		
		try {
			if(login.getUsuario().isEmpty()) {
				return false;
			}
			if(login.getContraseņa().isEmpty()) {
				return false;
			}
			if (mapaContraseņas.get(login.getUsuario()) == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initMapaContraseņas() {
		
		mapaContraseņas = new HashMap<String, String>();
		
		mapaContraseņas.put("Jose", "1234");
		mapaContraseņas.put("Juan", "1234");
		mapaContraseņas.put("Pablo", "1234");
		
	}

}
