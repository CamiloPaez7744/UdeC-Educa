/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.IdentificationTypeFacade;
import entities.IdentificationType;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class IdentificationTypeServiceImp implements IdentificationTypeService {

    @EJB
    private IdentificationTypeFacade identificationTypeFacade;

    @Override
    public void create(IdentificationType identificationType) {
        identificationTypeFacade.create(identificationType);
    }

    @Override
    public void edit(IdentificationType identificationType) {
        identificationTypeFacade.edit(identificationType);
    }

    @Override
    public void remove(IdentificationType identificationType) {
        identificationTypeFacade.remove(identificationType);
    }

    @Override
    public IdentificationType find(Object id) {
        return identificationTypeFacade.find(id);
    }

    @Override
    public List<IdentificationType> findAll() {
        return identificationTypeFacade.findAll();
    }

    @Override
    public List<IdentificationType> findRange(int[] range) {
        return identificationTypeFacade.findRange(range);
    }

    @Override
    public int count() {
        return identificationTypeFacade.count();
    }
    
}
