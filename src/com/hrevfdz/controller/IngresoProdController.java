package com.hrevfdz.controller;

import com.hrevfdz.dao.IngresoProductoDAO;
import com.hrevfdz.model.IngresoProducto;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.MessagesUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class IngresoProdController {
    private List<IngresoProducto> ingresoProductos;
    private IngresoProducto ingresoProducto;
    private List<StockProducto> stockProductos;
    private StockProducto stockProducto;
        
    private Date fecha;

    public IngresoProdController() {
        ingresoProducto = new IngresoProducto();
        stockProducto = new StockProducto();
        doFindAllIngreso();
    }
    
    public void doFindAllIngreso() {
        IPharmacy<IngresoProducto> dao = new IngresoProductoDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fec = new Date();
            final String query = "SELECT i FROM IngresoProducto i WHERE i.fecha <= '" + sdf.format(fec) + "'";
            ingresoProductos = dao.findByQuery(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindIngresoBy() {
        IPharmacy<IngresoProducto> dao = new IngresoProductoDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String query = "";

        try {
            if (sdf.format(getFecha()).equals("")) {
                Date fec = new Date();
                query = "SELECT i FROM IngresoProducto i WHERE i.fecha <= '" + sdf.format(fec) + "'";
            } else {
                query = "SELECT i FROM IngresoProducto i WHERE i.fecha = '" + sdf.format(getFecha()) + "'";
            }
            ingresoProductos = dao.findByQuery(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<IngresoProducto> getIngresoProductos() {
        return ingresoProductos;
    }

    public void setIngresoProductos(List<IngresoProducto> ingresoProductos) {
        this.ingresoProductos = ingresoProductos;
    }

    public IngresoProducto getIngresoProducto() {
        return ingresoProducto;
    }

    public void setIngresoProducto(IngresoProducto ingresoProducto) {
        this.ingresoProducto = ingresoProducto;
    }

    public List<StockProducto> getStockProductos() {
        return stockProductos;
    }

    public void setStockProductos(List<StockProducto> stockProductos) {
        this.stockProductos = stockProductos;
    }

    public StockProducto getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(StockProducto stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
