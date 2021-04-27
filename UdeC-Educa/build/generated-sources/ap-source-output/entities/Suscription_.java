package entities;

import entities.Eventue;
import entities.Feedback;
import entities.Userue;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T23:37:35")
@StaticMetamodel(Suscription.class)
public class Suscription_ { 

    public static volatile SingularAttribute<Suscription, Userue> numberIdentification;
    public static volatile SingularAttribute<Suscription, Eventue> eventName;
    public static volatile ListAttribute<Suscription, Feedback> feedbackList;
    public static volatile SingularAttribute<Suscription, Integer> idSuscription;

}