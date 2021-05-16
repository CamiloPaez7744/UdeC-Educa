package controller.util;

import DAO.CategoryFacade;
import entities.Category;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("categoryConverter")

public class CategoryConverter implements Converter {

    @Inject
    private CategoryFacade categoryFacade;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Category){
            return ((Category) value).getCategoryName();
        } else {
            return ""+value.toString();
        }        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return (Category)this.categoryFacade.find(value);
    }
}
