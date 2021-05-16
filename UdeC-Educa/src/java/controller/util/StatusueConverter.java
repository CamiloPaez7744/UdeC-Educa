/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import DAO.StatusueFacade;
import entities.Statusue;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("statusueConverter")
public class StatusueConverter implements Converter {

    @Inject
    private StatusueFacade statusueFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
                 return (Statusue)this.statusueFacade.find(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Statusue) {         
            return ((Statusue) value).getIdStatus();
        } else {
            return "salida "+value.toString();
        }
    }

}
