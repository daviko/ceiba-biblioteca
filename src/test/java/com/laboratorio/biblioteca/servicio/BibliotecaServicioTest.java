package com.laboratorio.biblioteca.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.laboratorio.biblioteca.entidad.Libro;
import com.laboratorio.biblioteca.entidad.Prestamo;
import com.laboratorio.biblioteca.entidad.Usuario;
import com.laboratorio.biblioteca.negocio.BibliotecaNegocio;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaServicioTest {

	@InjectMocks
	private BibliotecaServicio servicio;

	@Mock
	private BibliotecaNegocio bibliotecaNegocio;

	@Test
	public void testConsultarUsuario() {
		Usuario usuario = new Usuario();
		boolean expected = true;
		when(bibliotecaNegocio.validarUsuario(usuario)).thenReturn(expected);

		boolean actual = servicio.consultarUsuario(usuario);

		assertEquals(expected, actual);
	}

	@Test
	public void testAgregarLibro() {
		Libro libro = new Libro();
		when(bibliotecaNegocio.agregarLibro(libro)).thenReturn(libro);

		Libro expected = servicio.agregarLibro(libro);

		assertEquals(expected, libro);
	}

	@Test
	public void testEliminarLibro() {
		Long isbn = 1L;
		doNothing().when(bibliotecaNegocio).eliminarLibro(isbn);

		servicio.eliminarLibro(isbn);

		verify(bibliotecaNegocio).eliminarLibro(isbn);
	}

	@Test
	public void testObtenerLibrosDisponibles() {
		List<Libro> expected = new ArrayList<>();
		when(bibliotecaNegocio.obtenerLibrosDisponibles()).thenReturn(expected);

		List<Libro> actual = servicio.obtenerLibrosDisponibles();

		assertEquals(expected, actual);
	}

	@Test
	public void testBuscarLibroIsbn() {
		Long isbn = 1L;
		Libro expected = new Libro();
		expected.setIsbn(isbn);
		when(bibliotecaNegocio.buscarLibroIsbn(isbn)).thenReturn(expected);

		Libro actual = servicio.buscarLibroIsbn(isbn);

		assertEquals(expected, actual);
	}

	@Test
	public void testPrestarLibro() {
		Long isbn = 1L;
		String nombre = "nombrePersona";
		doNothing().when(bibliotecaNegocio).prestarLibro(isbn, nombre);

		servicio.prestarLibro(isbn, nombre);

		verify(bibliotecaNegocio).prestarLibro(isbn, nombre);
	}

	@Test
	public void testBuscarLibrosPrestados() {
		List<Prestamo> expected = new ArrayList<>();
		when(bibliotecaNegocio.buscarLibrosPrestados()).thenReturn(expected);

		List<Prestamo> actual = servicio.buscarLibrosPrestados();

		assertEquals(expected, actual);
	}

	@Test
	public void testObtenerUsuarios() {
		List<Usuario> expected = new ArrayList<>();
		when(bibliotecaNegocio.obtenerUsuarios()).thenReturn(expected);

		List<Usuario> actual = servicio.obtenerUsuarios();

		assertEquals(expected, actual);
	}
	
	@Test
	public void testEditarLibro() {
		Libro libro = new Libro();
		when(bibliotecaNegocio.agregarLibro(libro)).thenReturn(libro);

		Libro expected = servicio.editarLibro(libro);

		assertEquals(expected, libro);
	}

}
