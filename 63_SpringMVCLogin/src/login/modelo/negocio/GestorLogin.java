package login.modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import login.modelo.entidad.Login;


@Component
@RequestScope
public class GestorLogin {

	private Map<String, String> mapaContraseñas; 
	
	public boolean validar(Login login) {
		
		initMapaContraseñas();
		
		if (login.getUsuario().isEmpty()) {
			return false;
		}
		
		if (login.getContraseña().isEmpty()) {
			return false;
		}
		
		if (mapaContraseñas.get(login.getUsuario()) == null) {
			return false;
		}
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		
		if(!passwordEncryptor.checkPassword(login.getContraseña(), mapaContraseñas.get(login.getUsuario()))) {
			return false;
		}
		return true;

	}
	
	private void initMapaContraseñas() {
		
		mapaContraseñas = new HashMap<String, String>();
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		
		mapaContraseñas.put("Jose", passwordEncryptor.encryptPassword("1234"));
		mapaContraseñas.put("Juan", passwordEncryptor.encryptPassword("1234"));
		mapaContraseñas.put("Pablo", passwordEncryptor.encryptPassword("1234"));
		
	}

}
