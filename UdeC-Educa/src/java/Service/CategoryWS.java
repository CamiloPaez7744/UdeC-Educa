/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.CompetitorFacade;
import entities.Competitor;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author kmilo
 */
@WebService(serviceName = "CategoryWS")
public class CategoryWS {
    @EJB
    private CompetitorFacade competitorFacade;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "suma")
    public double suma(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a + b;
    }
    @WebMethod(operationName = "findAll")
    public List<Competitor> findAll() {
        return competitorFacade.findAll();
    }
    
}
