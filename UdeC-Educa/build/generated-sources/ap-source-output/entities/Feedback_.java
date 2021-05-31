package entities;

import entities.Suscription;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-30T22:08:30")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, String> descriptionfeed;
    public static volatile SingularAttribute<Feedback, Integer> idFeedback;
    public static volatile SingularAttribute<Feedback, Integer> calification;
    public static volatile SingularAttribute<Feedback, Suscription> idSuscription;

}