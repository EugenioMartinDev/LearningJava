package login.modelo.negocio;

import java.util.HashMap;
import java.util.Map;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import login.modelo.entidad.Login;
import login.modelo.persistencia.DaoLogin;


@Service("gl")
@RequestScope
public class GestorLogin {

	@Autowired
	private DaoLogin daoLogin;

	@Autowired
	private Login login;
		
	private BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	
	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public boolean accesoValidado(ModelAndView mav) {
		
		if (login.getUsuario().isEmpty()
			||
			login.getPassword().isEmpty()) {
			mav.addObject("error", "No se han introducido todos los datos");
			return false;
		}		

		return true;
	}
	
	public boolean registroValidado(ModelAndView mav) {
		
		if (login.getUsuario().isEmpty()
		||
		login.getPassword().isEmpty()
		||
		login.getNombre().isEmpty()
		||
		login.getDireccion().isEmpty()
		||
		login.getEmail().isEmpty()
		||
		login.getTelefono().isEmpty()) {
			mav.addObject("error", "Todos los datos son obligatorios. Vuelva a intentarlo");
			return false;
		}		
			
		return true;
	}


	public boolean registrado(ModelAndView mav) {

		Login loginDB = daoLogin.findByUsuario(login.getUsuario()); 
		
		if (loginDB == null) {
			mav.addObject("error", "El usuario no esta registrado");
			return false;
		}

		try {
			if(!passwordEncryptor.checkPassword(login.getPassword(), loginDB.getPassword())) {
				mav.addObject("error", "La contraseña es erronea");
				return false;
			}
		} catch (Exception ex) {
			mav.addObject("error", "Ha fallado la encriptacion");
			return false;
		}
			
		mav.addObject("usuario", loginDB.getUsuario());
		return true;
	}

	public boolean usuarioDuplicado(ModelAndView mav) {
		
		Login loginDB = daoLogin.findByUsuario(login.getUsuario());
		
		if (loginDB != null) {
			return true;
		} else {
			mav.addObject("error", "Este usuario ya esta dado de alta");
			return false;
		}
	}

	public boolean registrar(ModelAndView mav) {

		login.setPassword(passwordEncryptor.encryptPassword(login.getPassword()));
		
		login = daoLogin.save(login);
		if (login.getId() == 0) {
			mav.addObject("error", "Error transitorio. Vuelva a intentarlo");
			return false;
		} else {
			mav.addObject("usuario", login.getUsuario());
			mav.addObject("mensaje", "Usuario registrado con exito");
			return true;
		}
	}
	

}
