package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-30T09:32:21")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ { 

    public static volatile SingularAttribute<Auditoria, String> accion;
    public static volatile SingularAttribute<Auditoria, Integer> authKey;
    public static volatile SingularAttribute<Auditoria, Date> fecha;
    public static volatile SingularAttribute<Auditoria, String> contenido;
    public static volatile SingularAttribute<Auditoria, String> id_usuario;

}