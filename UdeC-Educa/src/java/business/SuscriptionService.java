/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Suscription;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kmilo
 */
@Local
public interface SuscriptionService {

    void create(Suscription suscription);

    void edit(Suscription suscription);

    void remove(Suscription suscription);

    Suscription find(Object id);

    List<Suscription> findAll();

    List<Suscription> findRange(int[] range);

    int count();
    
}
