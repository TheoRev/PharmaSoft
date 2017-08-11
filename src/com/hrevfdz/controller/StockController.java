package com.hrevfdz.controller;

import com.hrevfdz.dao.IngresoProductoDAO;
import com.hrevfdz.dao.LaboratoryDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.model.IngresoProducto;
import com.hrevfdz.model.Laboratory;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.MessagesUtil;
import com.hrevfdz.util.QueriesUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StockController extends IngresoProdController {

    private IPharmacy<StockProducto> dao;
    private List<StockProducto> stockProductos;
    private List<Laboratory> labs;
    private Laboratory lab;
    private StockProducto stockProducto;
    private List<IngresoProducto> ingresoProductos;
    private IngresoProducto ingresoProducto;
    private String accion;

    private SimpleDateFormat sdf;

    public void doFindAll() {
        dao = new StockProductoDAO();

        try {
            stockProductos = dao.findAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarDatos(StockProducto sp) throws ParseException {
        ingresoProducto.setCantidad(sp.getCantidad());
        ingresoProducto.setCosto(sp.getMonto());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fec = new Date();
        ingresoProducto.setFecha(sdf.parse(sdf.format(fec)));
        sdf = new SimpleDateFormat("HH:mm:ss");
        ingresoProducto.setHora(sdf.parse(sdf.format(fec)));
        ingresoProducto.setCodStock(sp);
    }

    private void doCreate() {
        dao = new StockProductoDAO();

        try {
            boolean result = dao.Create(stockProducto);

            if (result) {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doUpdate(StockProducto sp) {
        dao = new StockProductoDAO();

        try {
            boolean result = dao.Update(stockProducto);

            if (result) {
                stockProductos.clear();
                doFindAll();
                JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doDelete(StockProducto sp) {
        dao = new StockProductoDAO();

        try {
            boolean result = dao.Delete(stockProducto);

            if (result) {
                stockProductos.clear();
                doFindAll();
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.DELETE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadData(DefaultTableModel dtm, JTable tblStock) {
        dtm = (DefaultTableModel) tblStock.getModel();
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (StockProducto st : stockProductos) {
            Object[] row = new Object[8];
            row[0] = st.getCodStock();
            row[1] = st.getNombre();
            row[2] = st.getPresentacion();
            row[3] = st.getCodLab();
            row[4] = st.getLote();
            row[5] = st.getMonto();
            row[6] = st.getCantidad();
            row[7] = sdf.format(st.getFecVen());
            dtm.addRow(row);
        }
        tblStock.setModel(dtm);
    }

    public void doGetLabs() {
        IPharmacy<Laboratory> daol = new LaboratoryDAO();

        try {
            labs = daol.findByQuery(QueriesUtil.STOCK_X_LABORATORY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetLabById(String condition) {
        IPharmacy<Laboratory> daol = new LaboratoryDAO();
//        Laboratory lab = null;

        try {
            this.lab = daol.findBy(QueriesUtil.STOCK_X_LABORATORY + condition);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public String colorearFila(int cant) {
        if (cant > 5) {
            return "background-color: #81F7D8";
        } else if (cant == 0) {
            return "background-color: #F78181";
        } else {
            return "background-color: #F1F577";
        }
    }

    public void doNew() {
        accion = AccionUtil.CREATE;
        stockProducto = new StockProducto();
        doGetLabs();
    }

    public void doUpgrade(StockProducto sp) {
        this.accion = AccionUtil.UPDATE;
        stockProducto = sp;
        doGetLabs();
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(stockProducto);
                break;
        }
    }

    public IPharmacy<StockProducto> getDao() {
        return dao;
    }

    public void setDao(IPharmacy<StockProducto> dao) {
        this.dao = dao;
    }

    public List<StockProducto> getStockProductos() {
        return stockProductos;
    }

    public void setStockProductos(List<StockProducto> stockProductos) {
        this.stockProductos = stockProductos;
    }

    public List<Laboratory> getLabs() {
        return labs;
    }

    public void setLabs(List<Laboratory> labs) {
        this.labs = labs;
    }

    public StockProducto getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(StockProducto stockProducto) {
        this.stockProducto = stockProducto;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Laboratory getLab() {
        return lab;
    }

    public void setLab(Laboratory lab) {
        this.lab = lab;
    }

}
