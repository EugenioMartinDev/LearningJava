package utils;

import java.util.Collections;
import java.util.HashMap;

public class Constantes {
	
	public static final String TITULO = "TITULO";
	public static final String DIRECTOR = "DIRECTOR";
	public static final String ANIOPROD = "ANIOPROD";
	public static final String GENERO = "GENERO";

	public static final int EXECUTED_WITHOUT_ERRORS = 0;
	public static final int ERROR_SOME_EMPTY_FIELDS = 1;
	public static final int ERROR_CRUD_IN_DATABASE = 2;
	public static final int ERROR_DUPLICATED_TITLE = 3;
    
    private static HashMap<Integer, String> mapaErrores  = new HashMap<>(); 
    
    static {  
        mapaErrores.put(EXECUTED_WITHOUT_ERRORS, "EJECUTADO SIN ERRORES");
        mapaErrores.put(ERROR_SOME_EMPTY_FIELDS, "NO EJECUTADO : ALGUNO DE LOS CAMPOS ESTÁ VACÍO O ES CERO");
        mapaErrores.put(ERROR_CRUD_IN_DATABASE, "NO EJECUTADO : ERROR EN LA BASE DATOS EN ALGUNA OPERACION CRUD");
        mapaErrores.put(ERROR_DUPLICATED_TITLE, "NO EJECUTADO : EL TITULO DE LA PELICULA YA EXISTE EN LA BASE DE DATOS");
    }
    
    
    public static String getNameFromValue(int value) {
    	

		if (mapaErrores.get(value) != null) {
			return mapaErrores.get(value);
		} else {
			return "NO EJECUTADO : ERROR SIN CATALOGAR (" + value + ")";}
    }
}