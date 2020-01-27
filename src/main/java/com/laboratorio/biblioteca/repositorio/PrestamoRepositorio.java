package com.laboratorio.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laboratorio.biblioteca.entidad.Prestamo;

/**
 * Se establece repositorio para la entidad prestamo
 * 
 * @author David Leonardo Agudelo Villa
 *
 */
@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {

}
