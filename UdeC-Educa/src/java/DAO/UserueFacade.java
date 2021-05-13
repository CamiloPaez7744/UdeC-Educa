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
import javax.persistence.StoredProcedureQuery;


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

    public Userue queryFindUser(String username) throws Exception{
        try {
            return (Userue)em.createNamedQuery("Userue.findByUsername").
                    setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Usuario no encontrado");
        }
    }
    
    public boolean userUnique(String identification) throws Exception{
        try {
            return (boolean) em.createNamedQuery("Userue.findByNumberIdentification").
                    setParameter("numberIdentification", identification).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Usuario existente");
        }
    }
    
    public void sp_UpdateUser(String id) {
        StoredProcedureQuery generateUsername = this.em.createNamedStoredProcedureQuery("sp_updateUser");
        generateUsername.setParameter("id", id);
        generateUsername.execute();
    }

    public void sp_EncryptPassword(String id, String password) {
        StoredProcedureQuery encryptPassword = this.em.createNamedStoredProcedureQuery("sp_encryptPassword");
        encryptPassword.setParameter("id", id);
        encryptPassword.setParameter("user_password", password);
        encryptPassword.execute();
    }
    
    public boolean sp_DecryptPassword(String id, String password) {
        StoredProcedureQuery decryptPassword = this.em.createNamedStoredProcedureQuery("sp_decryptPassword");
        boolean validate = false;
        decryptPassword.setParameter("id", id);
        decryptPassword.setParameter("user_password", password);
        decryptPassword.setParameter("res", false);
        decryptPassword.execute();

        long var = (long) decryptPassword.getOutputParameterValue("res");
        if (var == 1) {
            validate = true;
        }
        System.out.println(var);

        // boolean validate = (boolean) decryptPassword.getOutputParameterValue("res");
        return validate;
    }
   
    public boolean verifyUser(String user, String password) throws Exception{
        Userue userFound = queryFindUser(user);
        return sp_DecryptPassword(userFound.getNumberIdentification(), password);
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
