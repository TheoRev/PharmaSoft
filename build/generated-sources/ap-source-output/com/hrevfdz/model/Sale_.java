package com.hrevfdz.model;

import com.hrevfdz.model.StockProducto;
import com.hrevfdz.model.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-15T22:35:01")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, Date> fecha;
    public static volatile SingularAttribute<Sale, Double> precio;
    public static volatile SingularAttribute<Sale, Integer> codSale;
    public static volatile SingularAttribute<Sale, Double> subtotal;
    public static volatile SingularAttribute<Sale, Date> hora;
    public static volatile SingularAttribute<Sale, StockProducto> codStock;
    public static volatile SingularAttribute<Sale, Integer> cantidad;
    public static volatile SingularAttribute<Sale, Users> userId;

}