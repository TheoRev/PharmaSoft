package com.hrevfdz.model;

import com.hrevfdz.model.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T14:51:20")
@StaticMetamodel(Recarga.class)
public class Recarga_ { 

    public static volatile SingularAttribute<Recarga, Date> fecha;
    public static volatile SingularAttribute<Recarga, Double> monto;
    public static volatile SingularAttribute<Recarga, String> numero;
    public static volatile SingularAttribute<Recarga, Integer> id;
    public static volatile SingularAttribute<Recarga, String> operador;
    public static volatile SingularAttribute<Recarga, Users> userId;

}