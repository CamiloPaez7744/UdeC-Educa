package controller;

import entities.Eventue;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import business.EventueService;
import entities.Category;
import entities.Statusue;
import entities.Userue;

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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("eventueController")
@SessionScoped
public class EventueController implements Serializable {
    @PersistenceContext(unitName = "UdeC-EducaPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    private Eventue current;
    private List<Statusue> statuses;
    private Statusue status;
    private List<Category> categories;
    private Category category;
    private DataModel items = null;
    @EJB
    private business.EventueService eventueService;
    @EJB
    private business.StatusueService statusueService;
    @EJB
    private business.CategoryService categoryService;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Userue user;

    public EventueController() {
    }

    public Eventue getSelected() {
        
        if (current == null) {
            current = new Eventue();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EventueService getEventueService() {
        return eventueService;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getEventueService().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getEventueService().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
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
        current = (Eventue) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Eventue();
        selectedItemIndex = -1;
        return "Create";
    }
    
    public Userue verify(String idUser) throws Exception {
        try {
            return (Userue) em.createNamedQuery("Userue.findByNumberIdentification").
                    setParameter("numberIdentification", idUser).getSingleResult();
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + e.getMessage());
            throw new Exception("No se encontro usuario");
        }

    }

    public String create() {    
        
        try {
            
            getEventueService().create(current, verify("1076670528"));
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EventueCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Eventue) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getEventueService().edit(current, user);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EventueUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Eventue) getItems().getRowData();
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
            user = new Userue(           
                    "1076670528");
            getEventueService().remove(current, user);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EventueDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getEventueService().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getEventueService().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    //Status

    public List<Statusue> getStatuses() {
        statuses=statusueService.findAll();
        return statuses;
    }

    public void setStatuses(List<Statusue> statuses) {
        this.statuses = statuses;
    }

    public Statusue getStatus() {
        return status;
    }

    public void setStatus(Statusue status) {
        this.status = status;
    }
    
    //Category

    public List<Category> getCategories() {
        categories=categoryService.findAll();
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return JsfUtil.getSelectItems(eventueService.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(eventueService.findAll(), true);
    }

    public Eventue getEventue(java.lang.String id) {
        return eventueService.find(id, user);
    }

    @FacesConverter(forClass = Eventue.class)
    public static class EventueControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EventueController controller = (EventueController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "eventueController");
            return controller.getEventue(getKey(value));
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
            if (object instanceof Eventue) {
                Eventue o = (Eventue) object;
                return getStringKey(o.getEventName());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Eventue.class.getName());
            }
        }

    }

}
