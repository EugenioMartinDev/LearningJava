package modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import modelo.entidad.Login;

public class GestorLogin {

	private Map<String, String> mapaContrase�as; 
	
	public boolean validar(Login login) {
		
		initMapaContrase�as();
		
		try {
			if(login.getUsuario().isEmpty()) {
				return false;
			}
			if(login.getContrase�a().isEmpty()) {
				return false;
			}
			if (mapaContrase�as.get(login.getUsuario()) == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initMapaContrase�as() {
		
		mapaContrase�as = new HashMap<String, String>();
		
		mapaContrase�as.put("Jose", "1234");
		mapaContrase�as.put("Juan", "1234");
		mapaContrase�as.put("Pablo", "1234");
		
	}

}
