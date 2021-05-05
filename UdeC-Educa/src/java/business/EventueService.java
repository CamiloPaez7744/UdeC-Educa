/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Eventue;
import entities.Userue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kmilo
 */
@Local
public interface EventueService {

    void create(Eventue eventue, Userue user);

    void edit(Eventue eventue, Userue user);

    void remove(Eventue eventue, Userue user)throws Exception;

    Eventue find(Object id, Userue user);

    List<Eventue> findAll();

    List<Eventue> findRange(int[] range);

    int count();
    
}
