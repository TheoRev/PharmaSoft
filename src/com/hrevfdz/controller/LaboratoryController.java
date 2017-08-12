package com.hrevfdz.controller;

import com.hrevfdz.dao.LaboratoryDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.dao.SuppliersDAO;
import com.hrevfdz.model.Laboratory;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.model.Suppliers;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.MessagesUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LaboratoryController extends PharmaSoftController {

    private List<Laboratory> laboratorios;
    private Laboratory laboratorio;
    private List<Suppliers> supplierses;
    List<StockProducto> productos;
    private Suppliers suppliers;
    private String accion;

    public void doListarLabs() {
        IPharmacy<Laboratory> dao = new LaboratoryDAO();

        try {
            String query = "SELECT l FROM Laboratory l";
            laboratorios = dao.findByQuery(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doCreate() {
        IPharmacy dao = new LaboratoryDAO();

        try {
            boolean result = dao.Create(laboratorio);

            if (result) {
                laboratorios.add(laboratorios.size(), laboratorio);
                laboratorio = new Laboratory();
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doUpdate(Laboratory lab) {
        IPharmacy dao = new LaboratoryDAO();

        try {
            boolean result = dao.Update(lab);

            if (result) {
                laboratorios.clear();
                doListarLabs();
                JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No cuenta con stock para realizar la venta", "Stock insuficiante", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doDelete(Laboratory lab) {
        IPharmacy dao = new LaboratoryDAO();

        try {
            boolean result = dao.Delete(lab);

            if (result) {
                laboratorios.clear();
                doListarLabs();
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doListSuppliers() {
        IPharmacy<Suppliers> dao = new SuppliersDAO();
        try {
            final String query = "SELECT s FROM Suppliers s";
            supplierses = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetSuplierByCod(int cod) {
        IPharmacy<Suppliers> dao = new SuppliersDAO();
        try {
            final String query = "SELECT s FROM Suppliers s WHERE s.codigo = " + cod;
            this.suppliers = dao.findBy(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doListPrducts(int id) {
        IPharmacy<StockProducto> dao = new StockProductoDAO();
        try {
            final String query = "SELECT p FROM StockProducto p WHERE p.codLab.codLab = " + id;
            productos = dao.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doLoadData(DefaultTableModel dtm, JTable tblLabs) {
        dtm = (DefaultTableModel) tblLabs.getModel();
        for (Laboratory l : laboratorios) {
            Object[] row = new Object[3];
            row[0] = l.getCodLab();
            row[1] = l.getNomLab();
            row[2] = l.getCodSupplier();
            dtm.addRow(row);
        }
        tblLabs.setModel(dtm);
    }

    public void doNew() {
        accion = AccionUtil.CREATE;
        laboratorio = new Laboratory();
    }

    public void doUpgrade(Laboratory l) {
        accion = AccionUtil.UPDATE;
        laboratorio = l;
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(laboratorio);
                break;
        }
    }

    public List<Laboratory> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratory> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public Laboratory getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratory laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<Suppliers> getSupplierses() {
        return supplierses;
    }

    public void setSupplierses(List<Suppliers> supplierses) {
        this.supplierses = supplierses;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }
}
