/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


import DAO.CategoryFacade;
import entities.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class CategoryServiceImp implements CategoryService {
    
    @EJB
    private CategoryFacade categoryFacade;

    @Override
    public void create(Category category) {
        categoryFacade.create(category);
    }

    @Override
    public void edit(Category category) {
        categoryFacade.edit(category);
    }

    @Override
    public void remove(Category category) {
        categoryFacade.remove(category);
    }

    @Override
    public Category find(Object id) {
        return categoryFacade.find(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryFacade.findAll();
    }

    @Override
    public List<Category> findRange(int[] range) {
        return categoryFacade.findRange(range);
    }

    @Override
    public int count() {
        return categoryFacade.count();
    }

    
    
}
