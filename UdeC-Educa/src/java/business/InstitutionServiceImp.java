/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.InstitutionFacade;
import entities.Institution;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author kmilo
 */
@Stateless
public class InstitutionServiceImp implements InstitutionService {

    @EJB
    private InstitutionFacade institutionFacade;

    @Override
    public void create(Institution institution) {
        institutionFacade.create(institution);
    }

    @Override
    public void edit(Institution institution) {
        institutionFacade.edit(institution);
    }

    @Override
    public void remove(Institution institution) {
        institutionFacade.remove(institution);
    }

    @Override
    public Institution find(Object id) {
        return institutionFacade.find(id);
    }

    @Override
    public List<Institution> findAll() {
        return institutionFacade.findAll();
    }

    @Override
    public List<Institution> findRange(int[] range) {
        return institutionFacade.findRange(range);
    }

    @Override
    public int count() {
        return institutionFacade.count();
    }
    
}
