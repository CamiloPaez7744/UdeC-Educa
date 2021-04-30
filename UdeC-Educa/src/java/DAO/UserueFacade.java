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
    
    //Creo que este condicional debería estar en el service también
    public boolean uniqueUser(String identification) {
        boolean unique = false;
        Query findByIdentification = this.em.createNamedQuery("Userue.findByNumberIdentification");
        findByIdentification.setParameter("number_identification", identification).getSingleResult();
        try {
            //Creo que este Userue user es el objeto que se crea a partir de los atrib del entity sin necesidad de un pojo
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

    public Userue queryFindUser(String username, String password) throws Exception{
        try {
            return (Userue)em.createNamedQuery("Userue.findByUsername").
                    setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Usuario no encontrado");
        }
    }
    
    /*
    El que llame este método debería tener el condicional 
            boolean confirmUser = false;
             if (user != null) {
                confirmUser = sp_DecryptPassword(user.getIdentification(), password);
                System.out.println(confirmUser);
                Para que cuando valide que no existe el mismo usuario encripte la contraseña
                        */

    
}
