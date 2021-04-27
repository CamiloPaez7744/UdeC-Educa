/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.StatusueFacade;
import entities.Statusue;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class StatusueServiceImp implements StatusueService {

    @EJB
    private StatusueFacade statusueFacade;

    @Override
    public void create(Statusue statusue) {
        statusueFacade.create(statusue);
    }

    @Override
    public void edit(Statusue statusue) {
        statusueFacade.edit(statusue);
    }

    @Override
    public void remove(Statusue statusue) {
        statusueFacade.remove(statusue);
    }

    @Override
    public Statusue find(Object id) {
        return statusueFacade.find(id);
    }

    @Override
    public List<Statusue> findAll() {
        return statusueFacade.findAll();
    }

    @Override
    public List<Statusue> findRange(int[] range) {
        return statusueFacade.findRange(range);
    }

    @Override
    public int count() {
        return statusueFacade.count();
    }
    
}
