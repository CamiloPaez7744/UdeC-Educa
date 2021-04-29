package entities;

import entities.Eventue;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-28T16:35:06")
@StaticMetamodel(Statusue.class)
public class Statusue_ { 

    public static volatile SingularAttribute<Statusue, String> idStatus;
    public static volatile SingularAttribute<Statusue, String> statusName;
    public static volatile ListAttribute<Statusue, Eventue> eventueList;

}