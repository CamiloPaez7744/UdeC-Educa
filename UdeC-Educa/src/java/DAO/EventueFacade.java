/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Eventue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kmilo
 */
@Stateless
public class EventueFacade extends AbstractFacade<Eventue> {

    @PersistenceContext(unitName = "UdeC-EducaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventueFacade() {
        super(Eventue.class);
    }
    
}
