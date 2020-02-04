package modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import modelo.entidad.Login;

public class GestorLogin {

	private Map<String, String> mapaContraseñas; 
	
	public boolean validar(Login login) {
		
		initMapaContraseñas();
		
		SimpleMD5Example simpleMD5 = new SimpleMD5Example();
		
		String generatedContraseña = simpleMD5.GeneratedPassword(login.getContraseña());
		
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
			if (!mapaContraseñas.get(login.getUsuario()).contentEquals(generatedContraseña)) {
				return false;
			}
			
			login.setContraseña(generatedContraseña);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initMapaContraseñas() {
		
		mapaContraseñas = new HashMap<String, String>();
		
		SimpleMD5Example simpleMD5 = new SimpleMD5Example();
		
		mapaContraseñas.put("Jose", simpleMD5.GeneratedPassword("1234"));
		mapaContraseñas.put("Juan", simpleMD5.GeneratedPassword("1234"));
		mapaContraseñas.put("Pablo", simpleMD5.GeneratedPassword("1234"));
		
	}

}
