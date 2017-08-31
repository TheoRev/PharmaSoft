package com.hrevfdz.model;

import com.hrevfdz.model.Laboratory;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-31T00:44:26")
@StaticMetamodel(StockProducto.class)
public class StockProducto_ { 

    public static volatile SingularAttribute<StockProducto, Date> fecVen;
    public static volatile SingularAttribute<StockProducto, Double> monto;
    public static volatile SingularAttribute<StockProducto, Double> costo;
    public static volatile SingularAttribute<StockProducto, String> lote;
    public static volatile SingularAttribute<StockProducto, String> presentacion;
    public static volatile SingularAttribute<StockProducto, Integer> codStock;
    public static volatile SingularAttribute<StockProducto, Integer> cantidad;
    public static volatile SingularAttribute<StockProducto, Boolean> state;
    public static volatile SingularAttribute<StockProducto, String> nombre;
    public static volatile SingularAttribute<StockProducto, Laboratory> codLab;

}