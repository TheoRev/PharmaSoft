package com.hrevfdz.model;

import com.hrevfdz.model.StockProducto;
import com.hrevfdz.model.Suppliers;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-27T00:36:45")
@StaticMetamodel(Laboratory.class)
public class Laboratory_ { 

    public static volatile SingularAttribute<Laboratory, String> nomLab;
    public static volatile ListAttribute<Laboratory, StockProducto> stockProductoList;
    public static volatile SingularAttribute<Laboratory, Suppliers> codSupplier;
    public static volatile SingularAttribute<Laboratory, Integer> codLab;

}