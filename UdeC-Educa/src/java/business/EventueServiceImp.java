/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.AuditoriaFacade;
import DAO.EventueFacade;
import entities.Eventue;
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
     private AuditoriaFacade auditoriaFacade; 

    /* Aquí estan las reglas de negocio que almacenan las acciones
    en auditoria*/
    
    @Override
    public void create(Eventue eventue) {     
        auditoriaFacade.defaulData("create", eventue.getEventName(), "1076670528");
        eventueFacade.create(eventue);
    }

    @Override
    public void edit(Eventue eventue) {
        auditoriaFacade.defaulData("edit", eventue.getEventName(), "1076670528");
        eventueFacade.edit(eventue);
        
    }
    
    // @Override
    public void remove(Eventue eventue, String userId) throws Exception{ 
        if(auditoriaFacade.verifyTime(userId)){
            eventueFacade.remove(eventue);
        } else {
             throw new Exception("No tiene cupo de interacción suficiente");
        }                
        
    }

    @Override
    public Eventue find(Object id) {
        auditoriaFacade.defaulData("find", "Consulta exitosa", "1076670528");
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

    @Override
    public void remove(Eventue eventue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
