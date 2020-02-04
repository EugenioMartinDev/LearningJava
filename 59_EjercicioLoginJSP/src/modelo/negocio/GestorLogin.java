package modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import modelo.entidad.Login;

public class GestorLogin {

	private Map<String, String> mapaContrase�as; 
	
	public boolean validar(Login login) {
		
		initMapaContrase�as();
		
		SimpleMD5Example simpleMD5 = new SimpleMD5Example();
		
		String generatedContrase�a = simpleMD5.GeneratedPassword(login.getContrase�a());
		
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
			if (!mapaContrase�as.get(login.getUsuario()).contentEquals(generatedContrase�a)) {
				return false;
			}
			
			login.setContrase�a(generatedContrase�a);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initMapaContrase�as() {
		
		mapaContrase�as = new HashMap<String, String>();
		
		SimpleMD5Example simpleMD5 = new SimpleMD5Example();
		
		mapaContrase�as.put("Jose", simpleMD5.GeneratedPassword("1234"));
		mapaContrase�as.put("Juan", simpleMD5.GeneratedPassword("1234"));
		mapaContrase�as.put("Pablo", simpleMD5.GeneratedPassword("1234"));
		
	}

}
