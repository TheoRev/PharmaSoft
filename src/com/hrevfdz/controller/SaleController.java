package com.hrevfdz.controller;

import com.hrevfdz.dao.SaleDAO;
import com.hrevfdz.model.Access;
import com.hrevfdz.model.Sale;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.report.Conexion;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.MessagesUtil;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class SaleController {
    
    private IPharmacy<Sale> dao;
    private List<Sale> sales;
    private Sale sale;
    private Sale tempSale;
    private List<StockProducto> stocks;
    private StockProducto producto;
    private String accion;
    private boolean estado;
    private Access access;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Date fecha = new Date();
    private String fecAct = sdf.format(fecha);

//    public void generarReporte() throws JRException, IOException, SQLException {
//        try {
////            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
////            fecha = sdfr.parse(sdfr.format(fecha));
////            Map<String, Object> parametro = new HashMap<String, Object>();
////            parametro.put("fec", fecha);
////
////            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/ventas.jasper"));
////            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametro, Conexion.getConexion());
////
////            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
////            String filename = "Reporte de Ventas - (" + sdfr.format(fecha) + ").pdf";
////            response.addHeader("Content-disposition", "attachment; filename=" + filename);
////            try (ServletOutputStream stream = response.getOutputStream()) {
////                JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
////                stream.flush();
////            }
////            FacesContext.getCurrentInstance().responseComplete();
//        } catch (ParseException ex) {
//            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void doFindAll() {
        dao = new SaleDAO();
        
        try {
            final String query = "SELECT s FROM Sale s ORDER BY s.fecha DESC";
            sales = dao.findByQuery(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, MessagesUtil.ERROR_SERVER_TITLE, MessagesUtil.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Sale> getSales() {
        return sales;
    }
    
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
    
    public Sale getSale() {
        return sale;
    }
    
    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
    public List<StockProducto> getStocks() {
        return stocks;
    }
    
    public void setStocks(List<StockProducto> stocks) {
        this.stocks = stocks;
    }
    
    public StockProducto getProducto() {
        return producto;
    }
    
    public void setProducto(StockProducto producto) {
        this.producto = producto;
    }
    
    public String getAccion() {
        return accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public Access getAccess() {
        return access;
    }
    
    public void setAccess(Access access) {
        this.access = access;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getFecAct() {
        return fecAct;
    }
    
    public void setFecAct(String fecAct) {
        this.fecAct = fecAct;
    }
    
    public Sale getTempSale() {
        return tempSale;
    }
    
    public void setTempSale(Sale tempSale) {
        this.tempSale = tempSale;
    }
    
}
