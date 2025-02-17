package org.spring.contactcrud.service.impl;


import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.spring.contactcrud.model.entities.Contacto;
import org.spring.contactcrud.repository.ContactoRepository;
import org.spring.contactcrud.service.IContactoService;

import java.util.List;

/**
 *
 * @author Eliezer Santiago
 * fecha: 16/02/2025
 * Desc: Clase que implementa los metodos de mi interface service al  CRUD
 * **/
@Stateless
public class ContactoServiceImpl implements IContactoService {

    //Inyeccion de dependencias
    //Instancia metodos de repository
    @EJB
    private ContactoRepository contactoRepository;

    //Configurar metodos y definimos lógica
    @Override
    public Contacto guardar(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    @Override
    public Contacto editar(Contacto contacto) {
        return contactoRepository.update(contacto);
    }

    @Override
    public void eliminar(Contacto contacto) {
        contactoRepository.delete(contacto);
    }

    @Override
    public List<Contacto> listar() {
        return contactoRepository.findAll();
    }
}
