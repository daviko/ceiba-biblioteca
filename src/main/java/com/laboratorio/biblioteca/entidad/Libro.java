package com.laboratorio.biblioteca.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase encargada de modelar el objeto libro
 * 
 * @author David Leonardo Agudelo Villa
 *
 */
@Entity
@Table(name = "LIBRO")
public class Libro {

	/**
	 * Atributo que representa el identificador del libro
	 */
	@Id
	@Column(name = "ISBN")
	private Long isbn;
	/**
	 * Atributo que representa el nombre del libro
	 */
	@Column(name = "NOMBRE")
	private String nombre;
	/**
	 * Atributo que representa la cantidad del inventario del libro
	 */
	@Column(name = "CANTIDAD_INVENTARIO")
	private int cantidadInventario;

	/**
	 * Atributo que representa la cantidad disponible del libro
	 */
	@Column(name = "CANTIDAD_DISPONIBLE")
	private int cantidadDisponible;

	public Libro(Long isbn, String nombre, int cantidadInventario, int cantidadDisponible) {

		this.isbn = isbn;
		this.nombre = nombre;
		this.cantidadInventario = cantidadInventario;
		this.cantidadDisponible = cantidadDisponible;

	}

	/**
	 * Constructor sin parametros de la clase Libro
	 */
	public Libro() {
		super();
	}

	/**
	 * Método encargado de obtener el valor del nombre
	 * 
	 * @return nombre el valor el nombre del libro
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método encargado de obtener el valor del nombre
	 * 
	 * @return nombre el valor el nombre del libro
	 */
	public int getCantidadInventario() {
		return cantidadInventario;
	}

	/**
	 * Método encargado de obtener el valor de la cantidad disponible del libro
	 * 
	 * @return nombre el valor el nombre del libro
	 */
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	/**
	 * Método encargado de obtener el valor del isbn
	 * 
	 * @return nombre el valor el isbn del libro
	 */
	public Long getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param cantidadInventario the cantidadInventario to set
	 */
	public void setCantidadInventario(int cantidadInventario) {
		this.cantidadInventario = cantidadInventario;
	}

	/**
	 * @param cantidadDisponible the cantidadDisponible to set
	 */
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

}
