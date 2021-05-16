/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import DAO.CompetitorFacade;
import entities.Competitor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("competitorConverter")
public class CompetitorConverter implements Converter {

    @Inject
    private CompetitorFacade competitorFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
                 return (Competitor)this.competitorFacade.find(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Competitor) {         
            return ((Competitor) value).getIdCompetitor();
        } else {
            return "salida "+value.toString();
        }
    }

}
