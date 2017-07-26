package com.hrevfdz.model;

import com.hrevfdz.model.Laboratory;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-26T00:52:18")
@StaticMetamodel(Suppliers.class)
public class Suppliers_ { 

    public static volatile SingularAttribute<Suppliers, Integer> codigo;
    public static volatile ListAttribute<Suppliers, Laboratory> laboratoryList;
    public static volatile SingularAttribute<Suppliers, String> encargado;
    public static volatile SingularAttribute<Suppliers, String> telefono;
    public static volatile SingularAttribute<Suppliers, String> nombre;
    public static volatile SingularAttribute<Suppliers, String> email;

}