package curso.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "operaciones")
@Component
@Scope("prototype")
public class Operacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private Double numero1;
	private Double numero2;
	private String operador;
	private Double resultado;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the numero1
	 */
	public Double getNumero1() {
		return numero1;
	}
	/**
	 * @param numero1 the numero1 to set
	 */
	public void setNumero1(Double numero1) {
		this.numero1 = numero1;
	}
	/**
	 * @return the numero2
	 */
	public Double getNumero2() {
		return numero2;
	}
	/**
	 * @param numero2 the numero2 to set
	 */
	public void setNumero2(Double numero2) {
		this.numero2 = numero2;
	}
	/**
	 * @return the operador
	 */
	public String getOperador() {
		return operador;
	}
	/**
	 * @param operador the operador to set
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}
	/**
	 * @return the resultado
	 */
	public Double getResultado() {
		return resultado;
	}
	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "Operacion [id=" + id + ", numero1=" + numero1 + ", numero2=" + numero2 + ", operador=" + operador
				+ ", resultado=" + resultado + "]";
	}

	

	
}
