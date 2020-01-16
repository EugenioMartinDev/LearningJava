package entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Director {

		
	/*
	 * 
	 * 
Ejercicio Peliculas
Quiero hacer una aplicacion en la que mostremos un menu tal como sigue
1 - Alta Pelicula
2 - Listar pelicula
3 - Buscar Pelicula por titulo
0 - salir el programa

Quiero guardar en un array list todas la peliculas que se vayan dando de alta. 
Que quiero guardar dentro de una pelicula
	titulo
	genero
	director
	año de estreno
Del director quiero guardar 2 cosas
 	nombre
	edad
A la hora de listar se mostrarán todos los datos de todas las peliculas que haya dado del alta el usuario
Cuando busquemos una pelicula por titulo deberemos de mostrar toda la información relevante a la pelicula
	 * 
	 */
	
	private String nombre;
	private int edad;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Director [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
}
