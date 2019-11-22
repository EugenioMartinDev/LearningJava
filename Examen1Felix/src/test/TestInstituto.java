package test;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Curso;
import entidad.Profesor;

public class TestInstituto {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno();
		a1.setDni("23123");
		a1.setEdad(34);
		a1.setNombre("Maria");
		a1.setSexo("Mujer");
		Alumno a2 = new Alumno();
		a2.setDni("423423");
		a2.setEdad(45);
		a2.setNombre("Eduardo");
		a2.setSexo("Hombre");
		Alumno a3 = new Alumno();
		a3.setDni("3414315");
		a3.setEdad(49);
		a3.setNombre("Marcos");
		a3.setSexo("Hombre");
		
		Curso c1 = new Curso();
		c1.setId(1);
		c1.setNombre("Matemáticas");
		c1.setPrecio(1200);
		c1.setHoras(25);
		Curso c2 = new Curso();
		c2.setId(2);
		c2.setNombre("Física");
		c2.setPrecio(1500);
		c2.setHoras(30);
		
		ArrayList<Alumno> listaAlumnoMatematicas = new ArrayList<Alumno>();
		listaAlumnoMatematicas.add(a1);
		listaAlumnoMatematicas.add(a2);
		
		ArrayList<Alumno> listaAlumnoFisica = new ArrayList<Alumno>();
		listaAlumnoFisica.add(a3);
		
		c1.setListaAlumnos(listaAlumnoMatematicas);
		c2.setListaAlumnos(listaAlumnoFisica);
		
		Profesor p1 = new Profesor();
		p1.setDni("3434234");
		p1.setEdad(36);
		p1.setNombre("Felix");
		p1.setSalario(1900);
		p1.setSexo("Hombre");

		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		listaCursos.add(c1);
		listaCursos.add(c2);
		
		p1.setListaCurso(listaCursos);
		
		System.out.println(p1);		
		
		
	}

}
