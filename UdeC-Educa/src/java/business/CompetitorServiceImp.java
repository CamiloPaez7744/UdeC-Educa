/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.CompetitorFacade;
import entities.Competitor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class CompetitorServiceImp implements CompetitorService {

   @EJB
   private CompetitorFacade competitorFacade;

    @Override
    public void create(Competitor competitor) {
        competitorFacade.create(competitor);
    }

    @Override
    public void edit(Competitor competitor) {
        competitorFacade.edit(competitor);
    }

    @Override
    public void remove(Competitor competitor) {
        competitorFacade.remove(competitor);
    }

    @Override
    public Competitor find(Object id) {
        return competitorFacade.find(id);
    }

    @Override
    public List<Competitor> findAll() {
        return competitorFacade.findAll();
    }

    @Override
    public List<Competitor> findRange(int[] range) {
        return competitorFacade.findRange(range);
    }

    @Override
    public int count() {
        return competitorFacade.count();
    }
}
