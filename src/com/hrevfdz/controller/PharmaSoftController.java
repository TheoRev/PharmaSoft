package com.hrevfdz.controller;

import com.hrevfdz.dao.PaymentsDAO;
import com.hrevfdz.dao.SaleDAO;
import com.hrevfdz.dao.StartWorkDAO;
import com.hrevfdz.model.StartWork;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.MessagesUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PharmaSoftController {

    private SimpleDateFormat sdf;
    private StartWork startWork;

    public double doGetMontoActualCaja(Date fecha) {
        IPharmacy dao = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        double montoAct = 0;

        try {
            double totalSales;
            double totalPays;
            String q1;
            String q2;
            String q3;

//            if (p == null) {
            q1 = "SELECT sw FROM StartWork sw WHERE sw.fecha = '" + sdf.format(fecha) + "'";
            q2 = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '" + sdf.format(fecha) + "'";
            q3 = "SELECT SUM(p.monto) FROM Payments p WHERE p.fecha = '" + sdf.format(fecha) + "'";
//            } else {
//                q1 = "SELECT sw FROM StartWork sw WHERE sw.fecha = '" + sdf.format(p.getFecha()) + "'";
//                q2 = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '" + sdf.format(p.getFecha()) + "'";
//                q3 = "SELECT SUM(p.monto) FROM Payments p WHERE p.fecha = '" + sdf.format(p.getFecha()) + "'";
//            }

            dao = (dao == null) ? new SaleDAO() : dao;
            totalSales = dao.findBy(q2) != null ? (double) dao.findBy(q2) : 0;
            dao = new PaymentsDAO();
            totalPays = dao.findBy(q3) != null ? (double) dao.findBy(q3) : 0;

            dao = new StartWorkDAO();
            startWork = (StartWork) dao.findBy(q1);
            montoAct = (startWork.getCapital() + totalSales) - totalPays;
//            startWork.setCapital(montoAct);
//            payments.setIdSw(startWork);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
        return montoAct;
    }
}
