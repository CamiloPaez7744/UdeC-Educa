package entities;

import entities.Userue;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-15T10:51:40")
@StaticMetamodel(Institution.class)
public class Institution_ { 

    public static volatile SingularAttribute<Institution, String> nameIntitution;
    public static volatile SingularAttribute<Institution, String> idInstitution;
    public static volatile ListAttribute<Institution, Userue> userueList;

}