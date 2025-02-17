package org.spring.contactcrud.repository;

import org.spring.contactcrud.model.entities.Contacto;
import org.spring.contactcrud.repository.persistence.CrudRepository;

import javax.persistence.EntityManager;

/**
 *
 * @author Eliezer Santiago
 * fecha: 16/02/2025
 * Desc: Clase primer repository para contactos y crear metodos CRUD
 * **/
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
