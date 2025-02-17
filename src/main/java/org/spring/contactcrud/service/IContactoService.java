package org.spring.contactcrud.service;

import org.spring.contactcrud.model.entities.Contacto;

import java.util.List;

/**
 *
 * @author Eliezer Santiago
 * fecha: 16/02/2025
 * Desc: Clase de logica de negocio con los metodos del CRUD
 * **/
public interface IContactoService {

    Contacto guardar(Contacto contacto);
    Contacto editar(Contacto contacto);
    void eliminar(Contacto contacto);
    List<Contacto> listar();
}
