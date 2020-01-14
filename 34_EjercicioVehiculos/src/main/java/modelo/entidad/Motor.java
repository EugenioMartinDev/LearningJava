package modelo.entidad;

public class Motor {
	private String tipoMotor;
	private int cv;
	private int cilindrada;
		
	public Motor() {
		super();
	}
	
	public Motor(String tipoMotor, int cv, int cilindrada) {
		super();
		this.tipoMotor = tipoMotor;
		this.cv = cv;
		this.cilindrada = cilindrada;
	}
	
	public String getTipoMotor() {
		return tipoMotor;
	}
	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}
	public int getCv() {
		return cv;
	}
	public void setCv(int cv) {
		this.cv = cv;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	@Override
	public String toString() {
		return "Motor [tipoMotor=" + tipoMotor + ", cv=" + cv + ", cilindrada=" + cilindrada + "]";
	}
	
}
