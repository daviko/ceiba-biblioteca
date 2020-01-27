package com.laboratorio.biblioteca.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase encargada de modelar el objeto usuario
 * 
 * @author David Leonardo Agudelo Villa
 *
 */
@Entity
@Table(name = "USUARIO")
public class Usuario {

	/**
	 * Atributo que representa el identificador del usuario
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	/**
	 * Atributo que representa el nombre del usuario
	 */
	@Column(name = "NOMBRE")
	private String nombreUsuario;
	/**
	 * Atributo que representa la contraseña del usuario
	 */
	@Column(name = "PASSWORD")
	private String contrasenia;

	/**
	 * Constructor de la calse Usuario
	 * 
	 * @param idUsuario     identificador del usuario
	 * @param nombreUsuario nombre del usuario
	 * @param contrasenia   contraseña del usuario
	 * @param biblioteca    biblioteca a la cual acude el usuario
	 */
	public Usuario(Long idUsuario, String nombreUsuario, String contrasenia) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	/**
	 * Constructor sin parametros de la clase
	 */
	public Usuario() {
		super();
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
