package controller.util;

import DAO.IdentificationTypeFacade;
import entities.IdentificationType;
import entities.Userue;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

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
        if (value instanceof Userue) {         
            return ((IdentificationType) value).getIdType();
        } else {
            return "salida "+value.toString();
        }
    }

}
