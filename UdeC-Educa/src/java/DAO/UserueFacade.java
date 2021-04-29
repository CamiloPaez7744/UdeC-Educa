/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Userue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kmilo
 */
@Stateless
public class UserueFacade extends AbstractFacade<Userue> {

    @PersistenceContext(unitName = "UdeC-EducaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserueFacade() {
        super(Userue.class);
    }
    
    public boolean uniqueUser(String identification) {
        boolean unique = false;
        Query findByIdentification = this.em.createNamedQuery("Userue.findByNumberIdentification");
        findByIdentification.setParameter("number_identification", identification).getSingleResult();
        try {
            Userue user = (Userue) findByIdentification.getSingleResult();
            if (user != null) {
                return unique = true;
            } else {
                return unique = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            unique = false;
        }
        return unique;
    }
    
    /*
    public Userue queryFindUser(String username, String password) {
        boolean confirmUser = false;
        Query findUser = this.em.createNamedQuery("Userue.findByUsername");
        findUser.setParameter("username", username);
        try {
            Userue user = (Userue) findUser.getSingleResult();
            if (user != null) {
                confirmUser = sp_DecryptPassword(user.getNumberIdentification(), password);
                System.out.println(confirmUser);
                if (confirmUser) {
                    //Instancias objeto Userue
                    user = new Userue(
                            user.getNumberIdentification(),
                            user.getFirstName(),
                            user.getSecondName(),
                            user.getFirstLastname(),
                            user.getSecondLastname(),
                            user.getEmail(),
                            user.getUsername()
                    );
                }

            } else {
                confirmUser = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            confirmUser = false;
        }

        return userDTO;
    }*/
    
}
