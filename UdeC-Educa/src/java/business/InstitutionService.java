/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Institution;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kmilo
 */
@Local
public interface InstitutionService {

    void create(Institution institution);

    void edit(Institution institution);

    void remove(Institution institution);

    Institution find(Object id);

    List<Institution> findAll();

    List<Institution> findRange(int[] range);

    int count();
    
}
