package controller.util;

import DAO.InstitutionFacade;
import entities.Institution;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("intitutionConverter")
public class InstitutionConverter implements Converter {

    @Inject
    private InstitutionFacade intitutionFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
                 return (Institution)this.intitutionFacade.find(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Institution) {         
            return ((Institution) value).getIdInstitution();
        } else {
            return "salida "+value.toString();
        }
    }

}
