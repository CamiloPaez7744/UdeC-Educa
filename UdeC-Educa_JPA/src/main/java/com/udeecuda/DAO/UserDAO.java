/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeecuda.DAO;

//Data Access Object
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public String SP_UpdateUser(String id) {
        StoredProcedureQuery generateUsername = this.em.createNamedStoredProcedureQuery("sp_updateuser");
        generateUsername.setParameter("id", id);
        generateUsername.execute();
        String username = (String) generateUsername.getOutputParameterValue("theUsername");
        return username;
    }

}
