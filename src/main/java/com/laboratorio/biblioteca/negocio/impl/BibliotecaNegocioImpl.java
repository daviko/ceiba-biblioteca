package com.laboratorio.biblioteca.negocio.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratorio.biblioteca.entidad.Libro;
import com.laboratorio.biblioteca.entidad.Prestamo;
import com.laboratorio.biblioteca.entidad.PrestamoException;
import com.laboratorio.biblioteca.entidad.Usuario;
import com.laboratorio.biblioteca.negocio.BibliotecaNegocio;
import com.laboratorio.biblioteca.repositorio.LibroRepositorio;
import com.laboratorio.biblioteca.repositorio.PrestamoRepositorio;
import com.laboratorio.biblioteca.repositorio.UsuarioRepositorio;

@Service
public class BibliotecaNegocioImpl implements BibliotecaNegocio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private LibroRepositorio libroRepositorio;

	@Autowired
	private PrestamoRepositorio prestamoRepositorio;

	@PersistenceContext
	private EntityManager entityManager;

	private static final String PALIDROMO = "Los libros palindromos solo se pueden utilizar en la biblioteca";
	private static final String PRESTADO = "No hay libros disponibles para prestar";
	private static final String NO_EXISTE = "El libro no existe";

	public Boolean validarUsuario(Usuario usuario) {
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		return usuarios.stream().anyMatch(user -> user.getNombreUsuario().equals(usuario.getNombreUsuario())
				&& user.getContrasenia().equals(usuario.getContrasenia()));
	}

	@Override
	public List<Libro> obtenerLibrosDisponibles() {
		String consultaLibrosDisponibles = "SELECT l FROM Libro l WHERE l.cantidadDisponible > 0";
		return entityManager.createQuery(consultaLibrosDisponibles).getResultList();
	}

	@Override
	public Libro agregarLibro(Libro libro) {
		return libroRepositorio.save(libro);
	}

	@Override
	public void eliminarLibro(Long isbn) {
		libroRepositorio.deleteById(isbn);
	}

	@Override
	public void prestarLibro(Long isbn, String nombre) {
		// Variable
		boolean palindromo = false;
		Libro libro = buscarLibroIsbn(isbn);
		// Se valida si el libro existe
		if (libro != null) {

			boolean prestado = validarLibrosDisponibles(libro);
			// Se valida si el libro ya se encuentra en prestamo
			if (prestado) {
				// Se asigna el valor que devuelve el metodo de verificaci?n
				palindromo = esPalindromo(isbn.toString());
				if (palindromo) {
					throw new PrestamoException(PALIDROMO);
				} else {
					Date fechaMaximaEntrega = validarFechaIsbn(isbn);
					Prestamo prestamo = new Prestamo(libro.getIsbn(), new Date(), fechaMaximaEntrega, nombre);
					prestamoRepositorio.save(prestamo);

					libro.setCantidadDisponible(libro.getCantidadDisponible() - 1);
					libroRepositorio.save(libro);
				}
			} else {
				throw new PrestamoException(PRESTADO);
			}
		} else {
			throw new PrestamoException(NO_EXISTE);
		}
	}

	public boolean validarLibrosDisponibles(Libro libroIsbnPrestado) {
		return libroIsbnPrestado != null && libroIsbnPrestado.getCantidadDisponible() > 0;
	}

	/**
	 * Metodo encargado de determinar si una palabra es o no palindroma
	 * 
	 * @param isbn isbn que se va a verificar
	 * @return si la cadena es o no palindroma
	 */
	public boolean esPalindromo(String isbn) {
		String clean = isbn.replaceAll("\\s+", "").toLowerCase();
		int length = clean.length();
		int forward = 0;
		int backward = length - 1;

		while (backward > forward) {
			char forwardChar = clean.charAt(forward++);
			char backwardChar = clean.charAt(backward--);
			if (forwardChar != backwardChar) {
				return false;
			}
		}
		return true;
	}

	public Date validarFechaIsbn(Long isbn) {
		String variable = "";
		int resultado = 0;

		for (int i = 0; i < isbn.toString().length(); i++) {
			char caracter = isbn.toString().charAt(i);
			if (Character.isDigit(caracter)) {
				variable = String.valueOf(caracter);
				resultado += Integer.parseInt(variable);
			}
		}
		if (resultado > 30) {
			return obtenerFecha();
		} else {
			return null;
		}
	}

	/**
	 * Metodo encargado de obtener la fecha maxima
	 * 
	 * @return la fecha maxima de entrega
	 */
	public Date obtenerFecha() {
		LocalDate resultado = LocalDate.now();
		int addedDays = 0;

		while (addedDays < 15) {
			resultado = resultado.plusDays(1);
			if (resultado.getDayOfWeek() != DayOfWeek.SUNDAY) {
				++addedDays;
			}
		}

		return Date.from(resultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public Libro buscarLibroIsbn(Long isbn) {
		return libroRepositorio.findById(isbn).orElse(null);
	}

	@Override
	public List<Prestamo> buscarLibrosPrestados() {
		return prestamoRepositorio.findAll();
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioRepositorio.findAll();
	}

}
