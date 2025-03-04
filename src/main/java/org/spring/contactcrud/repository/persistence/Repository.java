package org.spring.contactcrud.repository.persistence;

import jakarta.ejb.Local;

import java.util.List;

/**
 *
 * @author Eliezer Santiago
 * fecha: 16/02/2025
 * Desc: Clase repository de contactos
 * **/
@Local
public interface Repository <T>{
    //Manejo de clase generica
    T save(T entity);
    T update(T entity);
    T findById(Object entityId);
    void delete(T entity);

    List<T> findAll();


}
