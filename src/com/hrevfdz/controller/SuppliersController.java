package com.hrevfdz.controller;

import com.hrevfdz.dao.SuppliersDAO;
import com.hrevfdz.model.Suppliers;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.MessagesUtil;
import java.util.List;
import javax.swing.JOptionPane;

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

    public void doCreate() {
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

    public void doUpdate(Suppliers s) {
        IPharmacy dao = new SuppliersDAO();

        try {
            boolean result = dao.Update(s);

            if (result) {
                supplierses.clear();
                doFindAll();
                suppliers = new Suppliers();
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No cuenta con stock para realizar la venta", "Stock insuficiante", JOptionPane.ERROR_MESSAGE);
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
