package com.laboratorio.biblioteca.negocio;

import java.util.List;

import com.laboratorio.biblioteca.entidad.Libro;
import com.laboratorio.biblioteca.entidad.Prestamo;
import com.laboratorio.biblioteca.entidad.Usuario;

public interface BibliotecaNegocio {

	public Boolean validarUsuario(Usuario usuario);

	public Libro agregarLibro(Libro libro);

	public void eliminarLibro(Long isbn);

	public Libro buscarLibroIsbn(Long isbn);

	public List<Libro> obtenerLibrosDisponibles();

	public void prestarLibro(Long isbn, String nombre);

	public List<Prestamo> buscarLibrosPrestados();

	public List<Usuario> obtenerUsuarios();

}
