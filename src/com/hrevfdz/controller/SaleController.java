package com.hrevfdz.controller;

import com.hrevfdz.report.Conexion;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class SaleController {
    private Date fecha = new Date();
    
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
}
