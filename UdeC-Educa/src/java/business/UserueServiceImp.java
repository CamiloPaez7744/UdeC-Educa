/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.UserueFacade;
import entities.Userue;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author UdeC-Educa
 */
@Stateless
public class UserueServiceImp implements UserueService {
    
    @EJB
    private UserueFacade userueFacade; 

    @Override
    public void create(Userue userue) {
        userueFacade.create(userue);
    }

    @Override
    public void edit(Userue userue) {
        userueFacade.edit(userue);
    }

    @Override
    public void remove(Userue userue) {
        userueFacade.remove(userue);
    }

    @Override
    public Userue find(Object id) {
        return userueFacade.find(id);
    }

    @Override
    public List<Userue> findAll() {
        return userueFacade.findAll();
    }

    @Override
    public List<Userue> findRange(int[] range) {
        return userueFacade.findRange(range);
    }

    @Override
    public int count() {
        return userueFacade.count();
    }
    
    // Aqui van los metodos que se crearon en el UserueFacade
    
    // @Override
    public boolean uniqueUser(String identification) throws Exception{
        return userueFacade.uniqueUser(identification);
    }
    
    // @Override
    public Userue queryFindUser(String username, String password) throws Exception{
        return userueFacade.queryFindUser(username, password);
    }
               
}