package com.hrevfdz.controller;

import com.hrevfdz.dao.IngresoProductoDAO;
import com.hrevfdz.dao.LaboratoryDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.model.IngresoProducto;
import com.hrevfdz.model.Laboratory;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.FramesUtil;
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
    private StockProducto stockProducto;
    private List<IngresoProducto> ingresoProductos;
    private IngresoProducto ingresoProducto;
    private String accion;

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

    public void doCreate() {
        dao = new StockProductoDAO();
        IngresoProductoDAO idao = new IngresoProductoDAO();

        try {
            boolean result = dao.Create(stockProducto);

            if (result) {
                stockProductos.add(stockProductos.size(), stockProducto);
                String query = "SELECT st FROM StockProducto st WHERE st.codStock = (SELECT MAX(st.codStock) FROM StockProducto st)";
                StockProducto tempStock = dao.findBy(query);
                doFindAllIngreso();
                asignarDatos(tempStock);
                boolean result2 = idao.Create(ingresoProducto);
                stockProducto = new StockProducto();

                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No cuenta con stock para realizar la venta", "Stock insuficiante", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doUpdate(StockProducto sp) {
        dao = new StockProductoDAO();
        IngresoProductoDAO idao = new IngresoProductoDAO();

        try {
            boolean result = dao.Update(stockProducto);

            if (result) {
                stockProductos.clear();
                doFindAll();
//                String query = "SELECT st FROM StockProducto st WHERE st.codStock = " + stockProducto.getCodStock();
//                StockProducto tempStock = dao.findBy(query);
                asignarDatos(sp);
                boolean result2 = idao.Create(ingresoProducto);
                doFindAllIngreso();
                if (result2) {
                    JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
                }
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

    public void doQuerySelectLab() {
        IPharmacy<Laboratory> dao = new LaboratoryDAO();

        try {
            labs = dao.findByQuery(QueriesUtil.STOCK_X_LABORATORY);
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
        doQuerySelectLab();
    }

    public void doUpgrade(StockProducto sp) {
        accion = AccionUtil.UPDATE;
        stockProducto = sp;
        doQuerySelectLab();
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

}
