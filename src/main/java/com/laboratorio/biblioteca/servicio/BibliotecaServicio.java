package com.laboratorio.biblioteca.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laboratorio.biblioteca.entidad.Libro;
import com.laboratorio.biblioteca.entidad.Prestamo;
import com.laboratorio.biblioteca.entidad.Usuario;
import com.laboratorio.biblioteca.negocio.BibliotecaNegocio;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BibliotecaServicio {

	@Autowired
	private BibliotecaNegocio bibliotecaNegocio;

	@GetMapping("/validarUsuario")
	public Boolean consultarUsuario(Usuario usuario) {
		return bibliotecaNegocio.validarUsuario(usuario);
	}

	@PostMapping("/agregarLibro")
	public Libro agregarLibro(@RequestBody Libro libro) {
		return bibliotecaNegocio.agregarLibro(libro);
	}

	@DeleteMapping("/eliminarLibro/{ISBN}")
	public void eliminarLibro(@PathVariable(name = "ISBN") Long isbn) {
		bibliotecaNegocio.eliminarLibro(isbn);
	}

	@GetMapping("/obtenerLibrosDisponibles")
	public List<Libro> obtenerLibrosDisponibles() {
		return bibliotecaNegocio.obtenerLibrosDisponibles();
	}

	@GetMapping("/buscarLibroIsbn/{ISBN}")
	public Libro buscarLibroIsbn(@PathVariable(name = "ISBN") Long isbn) {
		return bibliotecaNegocio.buscarLibroIsbn(isbn);
	}

	@PostMapping("/prestarLibro/{ISBN}/{NOMBRE}")
	public void prestarLibro(@PathVariable(name = "ISBN") Long isbn, @PathVariable(name = "NOMBRE") String nombre) {
		bibliotecaNegocio.prestarLibro(isbn, nombre);
	}

	@GetMapping("/buscarLibrosPrestados")
	public List<Prestamo> buscarLibrosPrestados() {
		return bibliotecaNegocio.buscarLibrosPrestados();
	}

	@GetMapping("/obtenerUsuarios")
	public List<Usuario> obtenerUsuarios() {
		return bibliotecaNegocio.obtenerUsuarios();
	}

	@PutMapping("/editarLibro")
	public Libro editarLibro(@RequestBody Libro libro) {
		return bibliotecaNegocio.agregarLibro(libro);
	}
}
