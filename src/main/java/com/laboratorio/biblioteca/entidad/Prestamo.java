package com.laboratorio.biblioteca.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase encargada de modelar el objeto prestamo
 * 
 * @author David Leonardo Agudelo Villa
 *
 */
@Entity
@Table(name = "PRESTAMO")
public class Prestamo {

	/**
	 * Atributo que representa el identificador del prestamo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;

	/**
	 * Atributo que representa el libre del prestamo
	 */
	@Column(name = "ISBN")
	private Long ISBN;

	/**
	 * Atributo que representa la fecha en que se realizo el prestamo
	 */
	@Column(name = "FECHA_SOLICITUD")
	private Date fechaSolicitud;
	/**
	 * Atributo que representa la fecha de entrega del prestamo
	 */
	@Column(name = "FECHA_ENTREGA")
	private Date fechaEntrega;
	/**
	 * Atributo que representa el nombre del usuario del prestamo
	 */
	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;

	/**
	 * @param idPrestamo
	 * @param libro
	 * @param fechaSolicitud
	 * @param fechaEntrega
	 * @param nombreUsuario
	 */
	public Prestamo(Long ISBN, Date fechaSolicitud, Date fechaEntrega, String nombreUsuario) {
		super();
		this.ISBN = ISBN;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * 
	 */
	public Prestamo() {
		super();
	}

	/**
	 * @return the idPrestamo
	 */
	public Long getIdPrestamo() {
		return idPrestamo;
	}

	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Long getISBN() {
		return ISBN;
	}

	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

}