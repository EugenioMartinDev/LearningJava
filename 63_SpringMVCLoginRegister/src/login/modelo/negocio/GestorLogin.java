package login.modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import login.modelo.entidad.Login;
import login.modelo.persistencia.DaoLogin;


@Service
@RequestScope
public class GestorLogin {

	@Autowired
	private DaoLogin daoLogin;

	private Map<String, String> mapaContrase�as; 
	
	public boolean validar(Login login) {
		
		initMapaContrase�as();
		
		if (login.getUsuario().isEmpty()) {
			return false;
		}
		
		if (login.getPassword().isEmpty()) {
			return false;
		}
		
		if (mapaContrase�as.get(login.getUsuario()) == null) {
			return false;
		}
		

		
		obtener(1);
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		
		if(!passwordEncryptor.checkPassword(login.getPassword(), mapaContrase�as.get(login.getUsuario()))) {
			return false;
		}
		return true;

	}
	
	private void initMapaContrase�as() {
		
		mapaContrase�as = new HashMap<String, String>();
		
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		
		mapaContrase�as.put("Jose", passwordEncryptor.encryptPassword("1234"));
		mapaContrase�as.put("Juan", passwordEncryptor.encryptPassword("1234"));
		mapaContrase�as.put("Pablo", passwordEncryptor.encryptPassword("1234"));
		
	}
	
	
	public Login obtener(int id) {
		return (Login) daoLogin.findById(id).get();
	}
	

}
