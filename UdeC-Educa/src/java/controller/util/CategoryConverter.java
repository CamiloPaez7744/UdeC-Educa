/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import DAO.CategoryFacade;
import entities.Category;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author diana
 */
@FacesConverter("categoryConverter")

public class CategoryConverter implements Converter {

    @Inject
    private CategoryFacade eventFacade;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Category){
            return ((Category) value).getCategoryName();
        } else {
            return "";
        }        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.eventFacade.find(Integer.valueOf(value));
    }
}
