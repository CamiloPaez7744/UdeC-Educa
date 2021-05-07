/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Auditoria;
import entities.Userue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diana
 */
@Stateless
public class AuditoriaFacade extends AbstractFacade<Auditoria> {

    @PersistenceContext(unitName = "UdeC-EducaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditoriaFacade() {
        super(Auditoria.class);
    }
    
    public Auditoria newAuth (Userue usuario, String accion, String contenido) throws ParseException{
        Auditoria nuevaAuth = null;
        nuevaAuth.setAuthKey(1);
        nuevaAuth.setNumberIdentification(usuario);
        nuevaAuth.setAccion(accion);
        nuevaAuth.setContenido(contenido);
        nuevaAuth.setFecha(currentDateTime());
        em.persist(nuevaAuth);
        return nuevaAuth;
    }
    
    public Date currentDateTime () throws ParseException{
        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate  
        String strDateFormat = "yyyy-MM-dd HH: mm: ss"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        String dateFinal = objSDF.format(objDate);
        Date settingDate = new SimpleDateFormat("yyyy-MM-dd HH: mm: ss").parse(dateFinal); //cast a tipo date
        
        return settingDate;
    }
    
    public boolean verifyTime(Userue user) throws Exception {
        Auditoria auth = verifyLast(user.getNumberIdentification());
        int diference = diferenceTime(currentDateTime(), auth.getFecha()); 
        if (diference >= 15 ) {
            return true;
        }else {
            return false;
        }
    }
    
    public int diferenceTime(Date currentDate, Date lastDate){
        
        int diference = (int) (Math.abs(currentDate.getTime() - lastDate.getTime()) / (1000 * 60 * 60));
        return diference;
    }
    
    public Auditoria verifyLast(String idUser) throws Exception {
        try {
            return (Auditoria) em.createNamedQuery("Auditoria.findLast").
                    setParameter("id_usuario", idUser).getSingleResult();
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + e.getMessage());
            throw new Exception("Primer vez manejando eventos");
        }

    }
}