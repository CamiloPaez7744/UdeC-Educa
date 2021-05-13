/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import DAO.IdentificationTypeFacade;
import entities.IdentificationType;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


/**
 *
 * @author RAF
 */
@FacesConverter("identificationTypeConverter")
public class IdentificationTypeConverter implements Converter {

    @Inject
    private IdentificationTypeFacade identificationTypeFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
                 return (IdentificationType)this.identificationTypeFacade.find(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof IdentificationType) {         
            return ((IdentificationType) value).getIdType();
        } else {
            return "salida "+value.toString();
        }
    }

}
