/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.SuscriptionFacade;
import entities.Suscription;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class SuscriptionServiceImp implements SuscriptionService {

    @EJB
    private SuscriptionFacade suscriptionFacade;

    @Override
    public void create(Suscription suscription) {
        suscriptionFacade.create(suscription);
    }

    @Override
    public void edit(Suscription suscription) {
        suscriptionFacade.edit(suscription);
    }

    @Override
    public void remove(Suscription suscription) {
        suscriptionFacade.remove(suscription);
    }

    @Override
    public Suscription find(Object id) {
        return suscriptionFacade.find(id);
    }

    @Override
    public List<Suscription> findAll() {
        return suscriptionFacade.findAll();
    }

    @Override
    public List<Suscription> findRange(int[] range) {
        return suscriptionFacade.findRange(range);
    }

    @Override
    public int count() {
        return suscriptionFacade.count();
    }
}
