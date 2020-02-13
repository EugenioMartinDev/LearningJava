package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Operacion;
import curso.modelo.persistencia.OperacionDao;

@Service
public class GestorOperacion {

	@Autowired
	private OperacionDao od;
	
	/*
	 * Operaciones desde formulario:
	 * SUMAR
	 * RESTAR
	 * MULTIPLICAR
	 * DIVIDIR
	 *  
	 */
	
	public boolean Operar(Operacion operacion) {
		
		switch (operacion.getOperador()) {
		case "SUMA":
			Sumar(operacion);
			break;
		case "RESTA":
			Restar(operacion);
			break;
		case "PRODUCTO":
			Multiplicar(operacion);
			break;		
		case "DIVISION":
			Dividir(operacion);
			break;
		default:
			return false;
		}
		return true;
}
	
	private void Sumar(Operacion operacion) {
		
		operacion.setResultado((operacion.getNumero1() + operacion.getNumero2()));		
		od.save(operacion);
		
	}
	
	private void Restar(Operacion operacion) {
		
		operacion.setResultado((operacion.getNumero1() - operacion.getNumero2()));		
		od.save(operacion);
		
	}
	
	private void Multiplicar(Operacion operacion) {
		
		operacion.setResultado((operacion.getNumero1() * operacion.getNumero2()));		
		od.save(operacion);
		
	}
	
	private void Dividir(Operacion operacion) {
		
		operacion.setResultado((operacion.getNumero1() / operacion.getNumero2()));		
		od.save(operacion);
		
	}
	
	public List<Operacion> mostrarOperaciones() {
		
		return od.findAll();
	}
	
}
