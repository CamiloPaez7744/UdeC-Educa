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
import java.util.List;
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
        auditoriaFacade.defaulData("create", eventue.getEventName(), user);
        eventueFacade.create(eventue);
    }

    @Override
    public void edit(Eventue eventue, Userue user) {
        auditoriaFacade.defaulData("edit", eventue.getEventName(), user);
        eventueFacade.edit(eventue);
        
    }
    
    @Override
    public void remove(Eventue eventue, Userue user) throws Exception{ 
        if(auditoriaFacade.verifyTime(user)){
            eventueFacade.remove(eventue);
            auditoriaFacade.defaulData("remove", "Consulta exitosa", user);
        } else {
             throw new Exception("No tiene cupo de interacción suficiente");
        }                
        
    }

    //@Override
    public Eventue find(Object id, Userue user) {
        auditoriaFacade.defaulData("find", "Consulta exitosa", user);
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
