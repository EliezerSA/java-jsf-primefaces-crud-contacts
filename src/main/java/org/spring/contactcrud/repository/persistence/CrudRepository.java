package org.spring.contactcrud.repository.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Eliezer Santiago
 * fecha: 16/02/2025
 * Desc: Clase crud repository para generar metodos independientes de JPA con Hibernate
 * **/
public abstract class CrudRepository<T> implements Repository<T>{

    //Llamando al contexto de persistencia
    private final Class<T> entityClass;

    public CrudRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //Inyectar conexion a unidad de persistencia
    @PersistenceContext(unitName = "CRUD_PU")
    protected EntityManager em;

    protected abstract EntityManager getEntityManager();

    @Override
    public T save(T entity){
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity){
        getEntityManager().merge(entity);
        return entity;
    }

    @Override
    public T findById(Object entityId){
        return getEntityManager().find(entityClass, entityId);
    }

    @Override
    public void delete(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public List<T> findAll(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
