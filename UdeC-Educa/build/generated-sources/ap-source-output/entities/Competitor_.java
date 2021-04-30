package entities;

import entities.Userue;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-30T09:32:21")
@StaticMetamodel(Competitor.class)
public class Competitor_ { 

    public static volatile SingularAttribute<Competitor, String> idCompetitor;
    public static volatile SingularAttribute<Competitor, String> nameCompetitorType;
    public static volatile ListAttribute<Competitor, Userue> userueList;

}