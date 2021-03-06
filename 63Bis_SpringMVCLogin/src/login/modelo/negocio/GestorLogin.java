package login.modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import login.modelo.entidad.Login;


@Service
@RequestScope
public class GestorLogin {

	private Map<String, String> mapaContraseņas; 
	
	public boolean validar(Login login) {
		
		initMapaContraseņas();
		
		if (login.getUsuario().isEmpty()) {
			return false;
		}
		
		if (login.getContraseņa().isEmpty()) {
			return false;
		}
		
		if (mapaContraseņas.get(login.getUsuario()) == null) {
			return false;
		}
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		
		if(!passwordEncryptor.checkPassword(login.getContraseņa(), mapaContraseņas.get(login.getUsuario()))) {
			return false;
		}
		return true;

	}
	
	private void initMapaContraseņas() {
		
		mapaContraseņas = new HashMap<String, String>();
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		
		mapaContraseņas.put("Jose", passwordEncryptor.encryptPassword("1234"));
		mapaContraseņas.put("Juan", passwordEncryptor.encryptPassword("1234"));
		mapaContraseņas.put("Pablo", passwordEncryptor.encryptPassword("1234"));
		
	}

}
