/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.DAO;

//Data Access Object
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

//Access bewtween low level operations and high level operations
/**
 *
 * @author UdeC-Educa Dev's Team
 */
public class UserDAO {

    static UserData user = new UserData();

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.udeceduca_UdeC-Educa_JPA_war_1.0-SNAPSHOTPU");
    static EntityManager em = emf.createEntityManager();

    public void sp_UpdateUser(String id) {
        StoredProcedureQuery generateUsername = this.em.createNamedStoredProcedureQuery("sp_updateuser");
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
        decryptPassword.setParameter("id", id);
        decryptPassword.setParameter("user_password", password);
        decryptPassword.setParameter("res", true);
        decryptPassword.execute();
        
        boolean validate = (boolean) decryptPassword.getOutputParameterValue("res");
        return validate;
    }
    
    public boolean queryFindUser(String username, String password) {
        boolean confirmUser;
        Query findUser = this.em.createNamedQuery("UserData.findByUsername");
        findUser.setParameter("username", username);
        user = (UserData)findUser.getSingleResult();
        if (user != null){
            confirmUser = sp_DecryptPassword(user.getIdentification(), password);
        } else {
            confirmUser = false;
        }
        return confirmUser;
    }

}
