package entities;

import entities.Category;
import entities.Statusue;
import entities.Suscription;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-30T17:30:25")
@StaticMetamodel(Eventue.class)
public class Eventue_ { 

    public static volatile SingularAttribute<Eventue, Date> eventEndDate;
    public static volatile SingularAttribute<Eventue, Category> eventCategory;
    public static volatile SingularAttribute<Eventue, Statusue> eventStatus;
    public static volatile SingularAttribute<Eventue, String> seccional;
    public static volatile SingularAttribute<Eventue, String> eventName;
    public static volatile SingularAttribute<Eventue, String> programa;
    public static volatile SingularAttribute<Eventue, Date> eventStartDate;
    public static volatile ListAttribute<Eventue, Suscription> suscriptionList;
    public static volatile SingularAttribute<Eventue, String> facultad;

}