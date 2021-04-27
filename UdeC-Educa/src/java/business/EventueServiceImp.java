/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.EventueFacade;
import entities.Eventue;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class EventueServiceImp implements EventueService {
    
    @EJB
    private EventueFacade eventueFacade;

    @Override
    public void create(Eventue eventue) {
        eventueFacade.create(eventue);
    }

    @Override
    public void edit(Eventue eventue) {
        eventueFacade.edit(eventue);
    }

    @Override
    public void remove(Eventue eventue) {
        eventueFacade.remove(eventue);
    }

    @Override
    public Eventue find(Object id) {
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
