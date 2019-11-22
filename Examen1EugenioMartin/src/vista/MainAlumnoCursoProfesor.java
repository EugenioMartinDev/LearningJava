package vista;

import java.util.Scanner;

import modelo.entidad.Alumno;
import modelo.entidad.Curso;
import modelo.entidad.Profesor;

public class MainAlumnoCursoProfesor {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Declaración de 5 alumnos : alumno 1 y 2 en el curso 1 - alumno 3 en el curso
		// 2 - alumno 4 en el curso 3 - alumno 5 en el curso 4
		// Declaración de 4 cursos : curso 1 por el profesor 1 - curso 2 por el profesor
		// 1 - curso 3 por el profesor 2 - curso 4 por el profesor 3
		Alumno alumno1, alumno2, alumno3, alumno4, alumno5;
		Curso curso1, curso2, curso3, curso4;
		Profesor profesor1, profesor2, profesor3;

		// Asignación de datos de cursos EXCEPTO la asignación de profesor
		curso1 = new Curso();
		curso1.setIdCurso("UF1111");
		curso1.setNombreCurso("Desarrollo Uno");
		curso1.setHoras(90);
		curso1.setPrecio(257.32);

		curso2 = new Curso();
		curso2.setIdCurso("UF2222");
		curso2.setNombreCurso("Implementación Uno");
		curso2.setHoras(60);
		curso2.setPrecio(159.63);

		curso3 = new Curso();
		curso3.setIdCurso("UF3333");
		curso3.setNombreCurso("Desarrollo Dos");
		curso3.setHoras(90);
		curso3.setPrecio(307.26);

		curso4 = new Curso();
		curso4.setIdCurso("UF4444");
		curso4.setNombreCurso("Implementación Dos");
		curso4.setHoras(60);
		curso4.setPrecio(101.33);

		// Asignación de profesores - La clase Profesor añade el curso a la lista de
		// cursos
		profesor1 = new Profesor();
		profesor1.setdNI("11111111A");
		profesor1.setNombre("Jose Antonio");
		profesor1.setEdad(45);
		profesor1.setSalario(40000.57);
		profesor1.setSexo("H");
		profesor1.altaCurso(curso1);
		profesor1.altaCurso(curso2);

		profesor2 = new Profesor();
		profesor2.setdNI("22222222B");
		profesor2.setNombre("María Rosa");
		profesor2.setEdad(32);
		profesor2.setSalario(30000.48);
		profesor2.setSexo("M");
		profesor2.altaCurso(curso3);

		profesor3 = new Profesor();
		profesor3.setdNI("33333333C");
		profesor3.setNombre("Ana Julia");
		profesor3.setEdad(52);
		profesor3.setSalario(50000.92);
		profesor3.setSexo("M");
		profesor3.altaCurso(curso4);

		// Se añade el profesor al curso
		curso1.setProfesor(profesor1);
		curso2.setProfesor(profesor1);
		curso3.setProfesor(profesor2);
		curso4.setProfesor(profesor3);

		// Asignación de alumnos
		alumno1 = new Alumno();
		alumno1.setdNI("44444444D");
		alumno1.setNombreCompleto("Juan Gómez Pérez");
		alumno1.setEdad(27);
		alumno1.setSexo("H");
		alumno1.setCurso(curso1);

		alumno2 = new Alumno();
		alumno2.setdNI("55555555D");
		alumno2.setNombreCompleto("José Martínez López");
		alumno2.setEdad(24);
		alumno2.setSexo("H");
		alumno2.setCurso(curso1);

		alumno3 = new Alumno();
		alumno3.setdNI("66666666E");
		alumno3.setNombreCompleto("Ana Sánchez Del Olmo");
		alumno3.setEdad(31);
		alumno3.setSexo("M");
		alumno3.setCurso(curso2);

		alumno4 = new Alumno();
		alumno4.setdNI("77777777F");
		alumno4.setNombreCompleto("Lidia Jiménez Luarca");
		alumno4.setEdad(19);
		alumno4.setSexo("M");
		alumno4.setCurso(curso3);

		alumno5 = new Alumno();
		alumno5.setdNI("88888888G");
		alumno5.setNombreCompleto("Emilio Martín Rodríguez");
		alumno5.setEdad(20);
		alumno5.setSexo("H");
		alumno5.setCurso(curso4);

		// Se añade el alumno al curso
		curso1.altaAlumno(alumno1);
		curso1.altaAlumno(alumno2);
		curso2.altaAlumno(alumno3);
		curso3.altaAlumno(alumno4);
		curso4.altaAlumno(alumno5);

		
		// PRUEBA 1 - PRUEBAS EN CLASES INDIVIDUALES
		// =========================================
		
		System.out.println("PRUEBA 1 - PRUEBAS EN CLASES INDIVIDUALES");
		System.out.println("*****************************************");
		
		System.out.println("PRUEBA 1.1 - ASIGNACION E IMPRESION");
		System.out.println("___________________________________");
		
		System.out.println("// Se muestran los datos.\r\n" + 
				"		// De Alumno se imprime sus datos propios. Del curso solo se imprime la\r\n" + 
				"		// identidad del curso y su nombre\r\n" + 
				"		// De Curso se imprime sus datos propios y la lista de alumnos. Del profesor\r\n" + 
				"		// solo se imprime el DNI y el nombre.\r\n" + 
				"		// De Profesor se imprime sus datos propios y la lista de cursos que imparte, y por cada curso, la lista de alumnos. ");

		// Se muestran los datos.
		// De Alumno se imprime sus datos propios. Del curso solo se imprime la
		// identidad del curso y su nombre
		// De Curso se imprime sus datos propios y la lista de alumnos. Del profesor
		// solo se imprime el DNI y el nombre.
		// De Profesor se imprime sus datos propios y la lista de cursos que imparte, y por cada curso, la lista de alumnos.
		System.out.println("Profesor 1 : " + profesor1);
		System.out.println("Profesor 2 : " + profesor2);
		System.out.println("Profesor 3 : " + profesor3);
		System.out.println("Alumno 1 : " + alumno1);
		System.out.println("Alumno 2 : " + alumno2);
		System.out.println("Alumno 3 : " + alumno3);
		System.out.println("Alumno 4 : " + alumno4);
		System.out.println("Alumno 5 : " + alumno5);
		System.out.println("Curso 1 : " + curso1);
		System.out.println("Curso 2 : " + curso2);
		System.out.println("Curso 3 : " + curso3);
		System.out.println("Curso 4 : " + curso4);
		
		System.out.println("PRUEBA 1.2 - BAJAS E IMPRESION");
		System.out.println("______________________________");
		
		curso4.bajaAlumno(alumno5);
		System.out.println("Curso 4 : " + curso4);
		
		profesor3.bajaCurso(curso4);
		System.out.println("Profesor 3 : " + profesor3);
		
		// PRUEBA 2 - PRUEBA FINAL
		// =======================
		
		// Para un profesor se obtiene la lista de alumnos para un curso introducido por consola
		
		
		System.out.println("PRUEBA 2 - PRUEBAS EN CLASES INDIVIDUALES");
		System.out.println("*****************************************");
		
		System.out.println("PRUEBA 2.1 - OBTENER LA LISTA DE ALUMNOS PARA UN PROFESOR Y UN CURSO");
		System.out.println("____________________________________________________________________");
		
		System.out.println("Introduce el nombre del profesor");
		String nombre = sc.nextLine();
		Profesor profesor = new Profesor();
		Curso curso = new Curso();
		if (profesor1.getNombre().equals(nombre)) {
			profesor = profesor1;
		} else if (profesor2.getNombre().equals(nombre)) {
			profesor = profesor2;
		} else if (profesor3.getNombre().equals(nombre)) {
			profesor = profesor3;
		} else
		{
			System.out.println("No existe el profesor " + nombre);
		}
		
		if (profesor != null) {
			System.out.println("Introduce el curso");
			String cursoNombre = sc.nextLine();
			if (curso1.getNombreCurso().equals(cursoNombre) && curso1.getProfesor().getNombre().equals(nombre))  {
				curso = curso1;
			} else if (curso2.getNombreCurso().equals(cursoNombre) && curso2.getProfesor().getNombre().equals(nombre)) {
				curso = curso2;
			} else if (curso3.getNombreCurso().equals(cursoNombre) && curso3.getProfesor().getNombre().equals(nombre)) {
				curso = curso3; 
			} else if (curso4.getNombreCurso().equals(cursoNombre) && curso4.getProfesor().getNombre().equals(nombre)) {
				curso = curso4;
			} else
				System.out.println("No existe el curso " + curso + " para el profesor " + nombre);
		}
		
		if (curso != null) curso.listaAlumnos();
		}
		
}
