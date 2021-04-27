/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Competitor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kmilo
 */
@Local
public interface CompetitorService {

    void create(Competitor competitor);

    void edit(Competitor competitor);

    void remove(Competitor competitor);

    Competitor find(Object id);

    List<Competitor> findAll();

    List<Competitor> findRange(int[] range);

    int count();
    
}
