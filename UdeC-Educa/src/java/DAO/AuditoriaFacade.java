/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Auditoria;
import java.text.DateFormat;
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

    public Auditoria defaulData(String accion, String contenido, String usuario) {
        Auditoria nuevaAuth = null;
        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate  
        System.out.println(objDate);
        String strDateFormat = "aaaa-MM-dd a hh: mm: ss"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        System.out.println(objSDF.format(objDate));

        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        nuevaAuth.setId_usuario(usuario);
        nuevaAuth.setAccion(accion);
        nuevaAuth.setContenido(contenido);
        nuevaAuth.setFecha(objDate);
        em.persist(nuevaAuth);
        return nuevaAuth;
    }

    public Auditoria verifyLast(String idUser) throws Exception {
        try {
            return (Auditoria) em.createNamedQuery("Auditoria.findLast").
                    setParameter("id_usuario", idUser).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Primer vez manejando eventos");
        }

    }

    public boolean verifyTime(String idUser) throws Exception {
        Auditoria auth = verifyLast(idUser);
        Date lastDate = auth.getFecha();

        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate  
        System.out.println(objDate);
        String strDateFormat = "aaaa-MM-dd a hh: mm: ss"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        System.out.println(objSDF.format(objDate));

        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date currentDate = objDate;
        int lastMin = objDate.getMinutes();
        int currentMin = currentDate.getMinutes();
        int diference = lastMin - currentMin;
        if(diference > 15){
            return false;        
        } else {
            return true;
        }
                
    }

}

