package com.hrevfdz.controller;

import com.hrevfdz.dao.SuppliersDAO;
import com.hrevfdz.model.Suppliers;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.MessagesUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SuppliersController extends PharmaSoftController {

    private List<Suppliers> supplierses;
    private Suppliers suppliers;
    private String accion;

    public void doFindAll() {
        IPharmacy dao = new SuppliersDAO();

        try {
            final String query = "SELECT s FROM Suppliers s ORDER BY s.nombre";
            supplierses = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindByName(String name) {
        SuppliersDAO dao = new SuppliersDAO();

        try {
            supplierses = dao.findByName(name);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadData(DefaultTableModel dtm, JTable tblSupp) {
        dtm = (DefaultTableModel) tblSupp.getModel();

        for (Suppliers s : supplierses) {
            Object[] row = new Object[6];
            row[0] = s.getCodigo();
            row[1] = s.getNombre();
            row[2] = s.getEncargado();
            row[3] = s.getTelefono();
            row[4] = s.getEmail();
            row[5] = s.getRuc();
            dtm.addRow(row);
        }
        tblSupp.setModel(dtm);
    }

    private void doCreate() {
        IPharmacy dao = new SuppliersDAO();

        try {
            boolean result = dao.Create(suppliers);

            if (result) {
                supplierses.add(supplierses.size(), suppliers);
                doFindAll();
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doUpdate(Suppliers s) {
        IPharmacy dao = new SuppliersDAO();

        try {
            boolean result = dao.Update(s);

            if (result) {
                supplierses.clear();
                doFindAll();
                suppliers = new Suppliers();
                JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doDelete(Suppliers s) {
        IPharmacy dao = new SuppliersDAO();

        try {
            boolean result = dao.Delete(s);

            if (result) {
                supplierses.clear();
                doFindAll();
                suppliers = new Suppliers();
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doNew() {
        accion = AccionUtil.CREATE;
        suppliers = new Suppliers();
        doFindAll();
    }

    public void doUpgrade(Suppliers s) {
        accion = AccionUtil.UPDATE;
        suppliers = s;
        doFindAll();
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.NUEVA:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(suppliers);
                break;
        }
    }

    public List<Suppliers> getSupplierses() {
        return supplierses;
    }

    public void setSupplierses(List<Suppliers> supplierses) {
        this.supplierses = supplierses;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
