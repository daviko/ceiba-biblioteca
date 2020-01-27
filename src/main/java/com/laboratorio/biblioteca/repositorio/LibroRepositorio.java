package com.laboratorio.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratorio.biblioteca.entidad.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

}
