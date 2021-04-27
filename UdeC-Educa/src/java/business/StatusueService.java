/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Statusue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kmilo
 */
@Local
public interface StatusueService {

    void create(Statusue statusue);

    void edit(Statusue statusue);

    void remove(Statusue statusue);

    Statusue find(Object id);

    List<Statusue> findAll();

    List<Statusue> findRange(int[] range);

    int count();
    
}
