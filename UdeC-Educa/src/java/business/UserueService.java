 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Competitor;
import entities.IdentificationType;
import entities.Institution;
import entities.Userue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author UdeC-Educa
 */
@Local
public interface UserueService {

    void create(Userue userue);

    void edit(Userue userue);

    void remove(Userue userue);

    Userue find(Object id);

    List<Userue> findAll();

    List<Userue> findRange(int[] range);

    int count();

    public void create(Userue current, Institution institution, IdentificationType identificationType, Competitor competitor);
    
}
