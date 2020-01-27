package com.laboratorio.biblioteca.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.laboratorio.biblioteca.entidad.Libro;
import com.laboratorio.biblioteca.entidad.Prestamo;
import com.laboratorio.biblioteca.entidad.Usuario;
import com.laboratorio.biblioteca.negocio.impl.BibliotecaNegocioImpl;
import com.laboratorio.biblioteca.repositorio.LibroRepositorio;
import com.laboratorio.biblioteca.repositorio.PrestamoRepositorio;
import com.laboratorio.biblioteca.repositorio.UsuarioRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaNegocioImplTest {

	@InjectMocks
	private BibliotecaNegocioImpl negocio;

	@Mock
	private UsuarioRepositorio usuarioRepositorio;

	@Mock
	private LibroRepositorio libroRepositorio;

	@Mock
	private PrestamoRepositorio prestamoRepositorio;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEliminarLibro() {
		Long isbn = 1L;
		doNothing().when(libroRepositorio).deleteById(isbn);

		negocio.eliminarLibro(isbn);

		verify(libroRepositorio).deleteById(isbn);
	}

	@Test
	public void testBuscarLibrosPrestados() {
		List<Prestamo> expected = new ArrayList<>();
		when(prestamoRepositorio.findAll()).thenReturn(expected);

		List<Prestamo> actual = negocio.buscarLibrosPrestados();

		assertEquals(expected, actual);
	}

	@Test
	public void testObtenerUsuarios() {
		List<Usuario> expected = new ArrayList<>();
		when(usuarioRepositorio.findAll()).thenReturn(expected);

		List<Usuario> actual = negocio.obtenerUsuarios();

		assertEquals(expected, actual);
	}

	@Test
	public void testValidarLibrosDisponibles() {
		Libro libroIsbnPrestado = new Libro();
		libroIsbnPrestado.setCantidadDisponible(1);

		boolean resultado = negocio.validarLibrosDisponibles(libroIsbnPrestado);
		assertTrue(resultado);
	}

	@Test
	public void testValidarLibrosDisponiblesFalso() {
		boolean resultado = negocio.validarLibrosDisponibles(null);
		assertFalse(resultado);
	}

	@Test
	public void testEsPalindromo() {
		String isbn = "1001";
		boolean esPalindromo = negocio.esPalindromo(isbn);
		assertTrue(esPalindromo);
	}

	@Test
	public void testNoEsPalindromo() {
		String isbn = "100";
		boolean esPalindromo = negocio.esPalindromo(isbn);
		assertFalse(esPalindromo);
	}

	@Test
	public void testObtenerFecha() {
		Date fecha = negocio.obtenerFecha();
		assertNotNull(fecha);
	}

	@Test
	public void testBuscarLibroIsbn() {
		Long isbn = 2L;
		Libro expected = new Libro();
		expected.setIsbn(isbn);
		when(libroRepositorio.findById(isbn)).thenReturn(Optional.of(expected));

		Libro actual = negocio.buscarLibroIsbn(isbn);

		assertEquals(expected, actual);
	}

	@Test
	public void testValidarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setContrasenia("contrasenia");
		usuario.setNombreUsuario("nombreUsuario");

		List<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios.add(usuario);
		when(usuarioRepositorio.findAll()).thenReturn(listaUsuarios);

		boolean resultado = negocio.validarUsuario(usuario);

		assertTrue(resultado);
	}

	@Test
	public void testValidarUsuarioFalse() {
		Usuario usuario = new Usuario();
		usuario.setContrasenia("contrasenia");
		usuario.setNombreUsuario("nombreUsuario");

		List<Usuario> listaUsuarios = new ArrayList<>();
		when(usuarioRepositorio.findAll()).thenReturn(listaUsuarios);

		boolean resultado = negocio.validarUsuario(usuario);

		assertFalse(resultado);
	}

	@Test
	public void testAgregarLibro() {
		Libro libro = new Libro();
		when(libroRepositorio.save(libro)).thenReturn(libro);

		Libro actual = negocio.agregarLibro(libro);

		assertEquals(libro, actual);
	}

	@Test
	public void testValidarFechaIsbNull() {
		Long isbn = 12345L;
		Date fecha = negocio.validarFechaIsbn(isbn);
		assertNull(fecha);
	}

	@Test
	public void testValidarFechaIsbn() {
		Long isbn = 12345678L;
		Date fecha = negocio.validarFechaIsbn(isbn);
		assertNotNull(fecha);
	}

}
