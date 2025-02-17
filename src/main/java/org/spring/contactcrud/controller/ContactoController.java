package org.spring.contactcrud.controller;


import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.spring.contactcrud.model.entities.Contacto;
import org.spring.contactcrud.service.IContactoService;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eliezer Santiago
 * fecha: 17/02/2025
 * Desc: Clase controladora de contactos que implementa las petiiones HTTP al  CRUD
 * **/
@Getter
@Setter
@Named(value = "contactoMB")
@ViewScoped
public class ContactoController implements Serializable {

    @EJB
    private IContactoService contactoService;

    private Contacto contacto;
    private List<Contacto> contactos;

    public void nuevo(){
        contacto = new Contacto();
    }

    //Listado de contactos
    public List<Contacto> getContactos(){
        return contactos = contactoService.listar();
    }

    public void guardar(){
        if(contacto.getIdContacto() == null){
            contactoService.guardar(contacto);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Contacto Agregado"));
        }
        else {
            contactoService.editar(contacto);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Contacto Editado"));
        }
        nuevo();
        PrimeFaces.current().executeScript("PF('dlgContactoRegistro').hide()");
        PrimeFaces.current().ajax().update("form.messages","form:dt-contacto");
    }

}
