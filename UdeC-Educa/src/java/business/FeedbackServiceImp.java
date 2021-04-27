/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.FeedbackFacade;
import entities.Feedback;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author kmilo
 */
@Stateless
public class FeedbackServiceImp implements FeedbackService {

    @EJB
    private FeedbackFacade feedbackFacade;

    @Override
    public void create(Feedback feedback) {
        feedbackFacade.create(feedback);
    }

    @Override
    public void edit(Feedback feedback) {
        feedbackFacade.edit(feedback);
    }

    @Override
    public void remove(Feedback feedback) {
        feedbackFacade.remove(feedback);
    }

    @Override
    public Feedback find(Object id) {
        return feedbackFacade.find(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackFacade.findAll();
    }

    @Override
    public List<Feedback> findRange(int[] range) {
        return feedbackFacade.findRange(range);
    }

    @Override
    public int count() {
        return feedbackFacade.count();
    }
}
