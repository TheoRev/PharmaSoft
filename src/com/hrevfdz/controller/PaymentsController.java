package com.hrevfdz.controller;

import com.hrevfdz.dao.AccessDAO;
import com.hrevfdz.dao.LaboratoryDAO;
import com.hrevfdz.dao.PaymentsDAO;
import com.hrevfdz.dao.SaleDAO;
import com.hrevfdz.dao.StartWorkDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.model.Access;
import com.hrevfdz.model.Laboratory;
import com.hrevfdz.model.Payments;
import com.hrevfdz.model.StartWork;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.util.MessagesUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PaymentsController extends PharmaSoftController {

    private List<Payments> paymentses;
    private Payments payments;
    private Access access;
    private List<StockProducto> productos;
    private StockProducto producto;
    private StartWork startWork;
    private List<Laboratory> laboratorys;
    private Laboratory laboratory;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    public PaymentsController() {
        this.payments = new Payments();
    }

    private String accion;
    private Date fecha = new Date();
    private String fecAct = sdf2.format(fecha);

    private void doCreate() {
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            if (doGetMontoActualCaja(new Date()) < payments.getMonto()) {
                JOptionPane.showMessageDialog(null, MessagesUtil.MONTO_CAJA_INSUFICIENTE, MessagesUtil.INSUFICIENTE_TITLE.toUpperCase(),
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                boolean result = dao.Create(payments);

                if (result) {
                    paymentses.add(paymentses.size(), payments);
                    doFindAll();
                    JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doUpdate(Payments p) {
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            if (doGetMontoActualCaja(new Date()) < payments.getMonto()) {
                JOptionPane.showMessageDialog(null, MessagesUtil.MONTO_CAJA_INSUFICIENTE, MessagesUtil.INSUFICIENTE_TITLE.toUpperCase(),
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                boolean result = dao.Update(p);

                if (result) {
                    paymentses.clear();
                    doFindAll();
                    payments = new Payments();
                    JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doDelete(Payments p) {
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            boolean result = dao.Delete(p);

            if (result) {
                paymentses.clear();
                doFindAll();
                payments = new Payments();
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetLaboratories() {
        IPharmacy<Laboratory> dao = new LaboratoryDAO();

        try {
            final String query = "SELECT l FROM Laboratory l ORDER BY l.nomLab";
            laboratorys = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshPayments(DefaultTableModel dtm, JTable tblPayments) {
        FramesUtil.limpiarTabla(tblPayments, (DefaultTableModel) tblPayments.getModel());
        doFindAll();
        try {
            loadData(dtm, tblPayments);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadData(DefaultTableModel dtm, JTable tblPayments) throws ParseException {
        dtm = (DefaultTableModel) tblPayments.getModel();

        sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Payments p : this.paymentses) {
            Object[] row = new Object[6];
            row[0] = p.getCodigo().toString();
            row[1] = sdf.format(p.getFecha());
            row[2] = FramesUtil.Redondear(p.getMonto());
            row[3] = p.getDescripcion();
            row[4] = p.getUserId();
            row[5] = p.getCodStock();
            dtm.addRow(row);
        }

        tblPayments.setModel(dtm);
    }

    public void doGetUserActive() {
        IPharmacy<Access> dao = new AccessDAO();

        try {
            final String query = "SELECT a FROM Access a WHERE a.id = (SELECT MAX(t.id) FROM Access t)";
            access = dao.findBy(query);
            this.payments.setUserId(access.getUserId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetProductos() {
        IPharmacy<StockProducto> dao = new StockProductoDAO();

        try {
            final String query = "SELECT p FROM StockProducto p WHERE p.cantidad > 0 AND p.codLab.codLab = " + laboratory.getCodLab() + " ORDER BY p.nombre";
            productos = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public StockProducto doGetProductByCod(int cod) {
        IPharmacy<StockProducto> dao = new StockProductoDAO();
        StockProducto sp = null;

        try {
            final String query = "SELECT p FROM StockProducto p WHERE p.codStock = " + cod;
            sp = dao.findBy(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
        return sp;
    }

    public void doGetCaja(Payments p) {
        IPharmacy dao = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            double totalSales;
            double totalPays;
            String q1;
            String q2;
            String q3;

            if (p == null) {
                q1 = "SELECT sw FROM StartWork sw WHERE sw.fecha = '" + sdf.format(new Date()) + "'";
                q2 = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '" + sdf.format(new Date()) + "'";
                q3 = "SELECT SUM(p.monto) FROM Payments p WHERE p.fecha = '" + sdf.format(new Date()) + "'";
            } else {
                q1 = "SELECT sw FROM StartWork sw WHERE sw.fecha = '" + sdf.format(p.getFecha()) + "'";
                q2 = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '" + sdf.format(p.getFecha()) + "'";
                q3 = "SELECT SUM(p.monto) FROM Payments p WHERE p.fecha = '" + sdf.format(p.getFecha()) + "'";
            }

            dao = (dao == null) ? new SaleDAO() : dao;
            totalSales = dao.findBy(q2) != null ? (double) dao.findBy(q2) : 0;
            dao = new PaymentsDAO();
            totalPays = dao.findBy(q3) != null ? (double) dao.findBy(q3) : 0;

            dao = new StartWorkDAO();
            startWork = (StartWork) dao.findBy(q1);
            double montoAct = (startWork.getCapital() + totalSales) - totalPays;
            startWork.setCapital(montoAct);
//            payments.setIdSw(startWork);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doNew() {
        accion = AccionUtil.CREATE;
        payments = new Payments();
        doGetCaja(null);
        doGetLaboratories();
        doGetUserActive();
        doFindAll();
        try {
            payments.setFecha(sdf2.parse(fecAct));
        } catch (ParseException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doUpgrade(Payments p) {
        accion = AccionUtil.UPDATE;
        payments = p;
        doGetLaboratories();
        doGetUserActive();
        doGetCaja(p);
        doFindAll();
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(payments);
                break;
        }
    }

    public void doFindAll() {
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            final String query = "SELECT p FROM Payments p";
            paymentses = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindByFecha() {
        IPharmacy<Payments> dao = new PaymentsDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            final String query = "SELECT p FROM Payments p WHERE p.fecha = '" + sdf.format(fecha) + "'";
            paymentses = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Payments> getPaymentses() {
        return paymentses;
    }

    public void setPaymentses(List<Payments> paymentses) {
        this.paymentses = paymentses;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public List<StockProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<StockProducto> productos) {
        this.productos = productos;
    }

    public StockProducto getProducto() {
        return producto;
    }

    public void setProducto(StockProducto producto) {
        this.producto = producto;
    }

    public StartWork getStartWork() {
        return startWork;
    }

    public void setStartWork(StartWork startWork) {
        this.startWork = startWork;
    }

    public List<Laboratory> getLaboratorys() {
        return laboratorys;
    }

    public void setLaboratorys(List<Laboratory> laboratorys) {
        this.laboratorys = laboratorys;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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

}
