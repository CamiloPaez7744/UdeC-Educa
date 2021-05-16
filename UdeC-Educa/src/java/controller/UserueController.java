package controller;

import entities.Userue;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import business.UserueService;
import entities.IdentificationType;
import entities.Institution;
import entities.Competitor;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("userueController")
@SessionScoped
public class UserueController implements Serializable {

    private Userue current;
    private IdentificationType identificationType;
    private Institution institution;
    private Competitor competitor;
    private DataModel items = null;
    private List<IdentificationType> identificationTypes;
    private List<Institution> institutions;
    private List<Competitor> competitors;
    @EJB
    private business.UserueService userueService;
    @EJB
    private business.IdentificationTypeService identificationTypeService;
    @EJB
    private business.InstitutionService institutionService;
    @EJB
    private business.CompetitorService competitorService;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public UserueController() {
        
    }

    public Userue getSelected() {
        identificationTypes = identificationTypeService.findAll();
        institutions = institutionService.findAll();
        competitors = competitorService.findAll();
        if (current == null) {
            institution = new Institution();
            identificationType = new IdentificationType();
            competitor = new Competitor();
            current = new Userue();
            selectedItemIndex = -1;
        }
        return current;
    }

    private UserueService getUserueService() {
        return userueService;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getUserueService().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Userue) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Userue();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getUserueService().create(current, institution, identificationType, competitor);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserueCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Userue) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getUserueService().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserueUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Userue) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getUserueService().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserueDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getUserueService().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getUserueService().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(userueService.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(userueService.findAll(), true);
    }

    public Userue getUserue(java.lang.String id) {
        return userueService.find(id);
    }
    
    //IdentificationType

    public List<IdentificationType> getIdentificationTypes() {
        identificationTypes=identificationTypeService.findAll();
        return identificationTypes;
    }

    public void setIdentificationTypes(List<IdentificationType> identificationTypes) {
        this.identificationTypes = identificationTypes;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }
    
    // Institution

    public List<Institution> getInstitutions() {
        institutions=institutionService.findAll();
        return institutions;
    }

    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
    
    //Competitor

    public List<Competitor> getCompetitors() {
        competitors=competitorService.findAll();
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }
    
    
    @FacesConverter(forClass = Userue.class)
    public static class UserueControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UserueController controller = (UserueController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userueController");
            return controller.getUserue(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Userue) {
                Userue o = (Userue) object;
                return getStringKey(o.getNumberIdentification());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Userue.class.getName());
            }
        }
        
    }
    
}