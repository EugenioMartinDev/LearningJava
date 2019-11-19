package ejercicios;

public class Ejercicio17ArrayClase2 {

	public static void main(String[] args) {
		
		String[] dias = {"lunes", "martes", "mi�rcoles", "jueves", "viernes", "s�bado", "domingo"};
		
		String[] laborables = {"lunes", "martes", "mi�rcoles", "jueves", "viernes", null, null};
		
		String[] semanaSanta = {null, null, null, "jueves", "viernes", "s�bado", "domingo"}; 
		
		int diaSemana = 7;
		
		System.out.println("Hoy es : " + dias[diaSemana-1]);
		//caso 1 : array completo
		for(String dia : laborables) {
			System.out.print("caso 1 : array completo ");
			System.out.println("El d�a de la semana es : " + dia);
		}
		for(String dia : dias) {
			System.out.print("caso 1 : array completo ");
			System.out.println("El d�a de la semana es : " + dia.toUpperCase());
		}
		//caso 2 : array incompleto al final y se conoce el n�mero de elementos
		for (int i=0; i<5; i++) {
			System.out.print("caso 2 : array incompleto al final y se conoce el n�mero de elementos ");
			System.out.println("El d�a laborable de la semana es : " + laborables[i].toUpperCase());
		}					
		//caso 3 : array incompleto al final y se conoce el n�mero de elemetos
		int indice = 0;		
		while (indice<laborables.length && laborables[indice] != null) {
			System.out.print("caso 3 : array incompleto al final y se conoce el n�mero de elementos ");
			System.out.println("El d�a laborable de la semana es : " + laborables[indice].toUpperCase());
			indice++;
		}
		//caso 4 : array incompleto con huecos
		for(String dia : semanaSanta) {
			System.out.print("caso 4 : array incompleto con huecos ");
			if (dia != null)
				System.out.println("El d�a de la semana es : " + dia.toUpperCase());
			else
				System.out.println();
		}
		
		//Array bidemensional
		String [] diasDeMenu = {"lunes", "martes", "mi�rcoles"};
		
		String[][] menus = {
				{"macarrones","lomo","sandia"},
				{"sopa","garbanzo","cafe","copa"},
				{"ensalada","rabo de toro"}
		};
		
		System.out.println("Men�s ");
		
		for (int i=0; i<menus.length; i++) {
			System.out.println("D�a : " + diasDeMenu[i]);
			System.out.print("Comida de men� ");
			for (int j=0; j<menus[i].length; j++)
				System.out.print(menus[i][j] + " ");
			System.out.println();
				
		}
		
		int fila = 2;
		for (int j=0; j < menus[fila-1].length; j++)
			System.out.println(menus[fila-1][j] + " ");
		
		
	}

}
