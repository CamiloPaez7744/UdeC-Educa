/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Eventue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kmilo
 */
@Local
public interface EventueService {

    void create(Eventue eventue);

    void edit(Eventue eventue);

    void remove(Eventue eventue);

    Eventue find(Object id);

    List<Eventue> findAll();

    List<Eventue> findRange(int[] range);

    int count();
    
}
