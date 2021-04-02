/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.DAO;

//Data Access Object
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

//Access bewtween low level operations and high level operations
/**
 *
 * @author UdeC-Educa Dev's Team
 */
public class UserDAO implements DAO {

    static UserData user = new UserData();

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.udeceduca_UdeC-Educa_JPA_war_1.0-SNAPSHOTPU");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

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

    public boolean queryFindUser(String username, String password) {
        boolean confirmUser = false;
        Query findUser = UserDAO.em.createNamedQuery("UserData.findByUsername");
        findUser.setParameter("username", username);
        try {
            user = (UserData) findUser.getSingleResult();
            if (user != null) {
                confirmUser = sp_DecryptPassword(user.getIdentification(), password);
                System.out.println(confirmUser);
            } else {
                confirmUser = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            confirmUser = false;
        }
        return confirmUser;
    }

    public boolean uniqueUser(String identification) {
        boolean unique = false;
        Query findByIdentification = UserDAO.em.createNamedQuery("UserData.findByIdentification");
        findByIdentification.setParameter("identification", identification);
        try{
            user = (UserData) findByIdentification.getSingleResult();
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

    public void insertData(String identification, String first_name, String second_name, String first_lastname, String second_lastname, String email) {
       byte arr[] = new byte[] {1};
        user.setIdentification(identification);
        user.setFirstName(first_name);
        user.setSecondName(second_name);
        user.setFirstLastname(first_lastname);
        user.setSecondLastname(second_lastname);
        user.setEmail(email);
        user.setUsername("");
        user.setHashPass("");
        user.setEncPass(arr);
        et = em.getTransaction();
        et.begin();
        em.persist(user);
    }

    @Override
    public Object save(Object entity) {
        return entity;
    }

    @Override
    public Object update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
