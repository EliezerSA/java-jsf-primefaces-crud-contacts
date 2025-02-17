package org.spring.contactcrud.repository;

import jakarta.ejb.Stateless;
import org.spring.contactcrud.model.entities.Contacto;
import org.spring.contactcrud.repository.persistence.CrudRepository;

import jakarta.persistence.EntityManager;

/**
 *
 * @author Eliezer Santiago
 * fecha: 16/02/2025
 * Desc: Clase primer repository para contactos y crear metodos CRUD
 * **/
@Stateless
public class ContactoRepository extends CrudRepository<Contacto> {

    //Llamada general a los metodos del CrudRepository
    public ContactoRepository() {
        super(Contacto.class);
    }

    //Referencia a la conexion de la BD por medio de un metodo abstracto

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
