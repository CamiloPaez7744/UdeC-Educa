/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.AuditoriaFacade;
import DAO.EventueFacade;
import entities.Eventue;
import entities.Userue;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
//import DAO.AuditoriaFacade;

/**
 *
 * @author kmilo
 */
@Stateless
public class EventueServiceImp implements EventueService {
    
    @EJB
    private EventueFacade eventueFacade;
    @EJB
     private AuditoriaFacade auditoriaFacade; 

    /* Aquí estan las reglas de negocio que almacenan las acciones
    en auditoria*/
    
    @Override
    public void create(Eventue eventue, Userue user) {     
        try {
            auditoriaFacade.newAuth(user, "create", eventue.getEventName());
            eventueFacade.create(eventue);
        } catch (ParseException ex) {
            Logger.getLogger(EventueServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Eventue eventue, Userue user) {
        try {
            auditoriaFacade.newAuth( user, "edit", eventue.getEventName());
            eventueFacade.edit(eventue);
        } catch (ParseException ex) {
            Logger.getLogger(EventueServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void remove(Eventue eventue, Userue user) throws Exception{ 
        if(auditoriaFacade.verifyTime(user)){
            eventueFacade.remove(eventue);
            auditoriaFacade.newAuth(user, "remove", "Consulta exitosa");
        } else {
             throw new Exception("No tiene cupo de interacción suficiente");
        }                
        
    }

    //@Override
    public Eventue find(Object id, Userue user) {
        try {
            auditoriaFacade.newAuth(user, "find", "Consulta exitosa");
        } catch (ParseException ex) {
            Logger.getLogger(EventueServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventueFacade.find(id);
    }

    @Override
    public List<Eventue> findAll() {
        return eventueFacade.findAll();
    }

    @Override
    public List<Eventue> findRange(int[] range) {
        return eventueFacade.findRange(range);
    }

    @Override
    public int count() {
        return eventueFacade.count();
    }  
}
