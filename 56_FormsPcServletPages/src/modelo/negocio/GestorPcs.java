package modelo.negocio;

import java.util.LinkedHashMap;
import java.util.Map;

import modelo.entidad.Pc;

public class GestorPcs {

	public enum Procesador{
		NONE(0), INTEL_1(1), AMD_1(2), INTEL_2(3), AMD_2(4), INTEL_3(5), AMD_3(6);
		
	    private final int code;

	    private Procesador(final int code) {
	        this.code = code;
	    }

	    private static final Map<Integer, Procesador> BY_CODE_MAP = new LinkedHashMap<>();
	    static {
	        for (Procesador rae : Procesador.values()) {
	            BY_CODE_MAP.put(rae.code, rae);
	        }
	    }

	    public static Procesador forCode(int code) {
	        return BY_CODE_MAP.get(code);
	    }
	}
	
	public enum Memoria{
		NONE(0), MB_2(1), MB_4(2), MB_8(3), MB_16(4), MB_32(5);
		
	    private final int code;

	    private Memoria(final int code) {
	        this.code = code;
	    }

	    private static final Map<Integer, Memoria> BY_CODE_MAP = new LinkedHashMap<>();
	    static {
	        for (Memoria rae : Memoria.values()) {
	            BY_CODE_MAP.put(rae.code, rae);
	        }
	    }

	    public static Memoria forCode(int code) {
	        return BY_CODE_MAP.get(code);
	    }
	}
	
	public boolean Validar(Pc pc) {

		if (pc.getDevices() == null) {
			return false;
		}
		if (pc.getDevices().length == 0 || pc.getModelo().isEmpty()) {
			return false;
		}
	
		return true;
	}
	
	public String Xlate_Procesador(int procesador) {				
		return Procesador.forCode(procesador).name();
	}
	
	public String Xlate_Memoria(int memoria) {
		return Memoria.forCode(memoria).name();
	}
	
}
