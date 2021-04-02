/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author kmilo
 */
public class Prueba {
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.udeceduca_UdeC-Educa_JPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        StoredProcedureQuery proceso = em.createStoredProcedureQuery("sp_decryptPassword");
        proceso.registerStoredProcedureParameter("id", String.class, ParameterMode.IN);
        proceso.registerStoredProcedureParameter("user_password", String.class, ParameterMode.IN);
        proceso.registerStoredProcedureParameter("res", boolean.class, ParameterMode.INOUT);
        
        proceso.setParameter("id","176670528");
        proceso.setParameter("user_password", "12345");
        proceso.setParameter("res", true);
        
        et.begin();
        proceso.execute();
        long var = (long) proceso.getOutputParameterValue("res");
     
        System.out.println(var);
        et.commit();
        em.close();
    }
}
