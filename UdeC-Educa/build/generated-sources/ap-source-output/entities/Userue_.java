package entities;

import entities.Competitor;
import entities.IdentificationType;
import entities.Institution;
import entities.Suscription;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-30T09:32:21")
@StaticMetamodel(Userue.class)
public class Userue_ { 

    public static volatile SingularAttribute<Userue, String> firstLastname;
    public static volatile SingularAttribute<Userue, String> numberIdentification;
    public static volatile SingularAttribute<Userue, byte[]> encPass;
    public static volatile SingularAttribute<Userue, IdentificationType> identificationType;
    public static volatile SingularAttribute<Userue, Date> birthDate;
    public static volatile SingularAttribute<Userue, Competitor> competitorType;
    public static volatile ListAttribute<Userue, Suscription> suscriptionList;
    public static volatile SingularAttribute<Userue, String> firstName;
    public static volatile SingularAttribute<Userue, Institution> idIntitution;
    public static volatile SingularAttribute<Userue, Boolean> userRoler;
    public static volatile SingularAttribute<Userue, String> phone;
    public static volatile SingularAttribute<Userue, String> accessKey;
    public static volatile SingularAttribute<Userue, String> secondLastname;
    public static volatile SingularAttribute<Userue, String> email;
    public static volatile SingularAttribute<Userue, String> secondName;
    public static volatile SingularAttribute<Userue, String> username;

}