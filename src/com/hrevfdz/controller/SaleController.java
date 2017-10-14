package com.hrevfdz.controller;

import com.hrevfdz.dao.AccessDAO;
import com.hrevfdz.dao.SaleDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.dao.UsersDAO;
import com.hrevfdz.model.Access;
import com.hrevfdz.model.Sale;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.model.Users;
import com.hrevfdz.report.Conexion;
import com.hrevfdz.service.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.util.MessagesUtil;
import com.hrevfdz.util.QueriesUtil;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class SaleController extends PharmaSoftController {

    private IPharmacy<Sale> dao;
    private List<Sale> sales;
    private Sale sale;
    private Sale tempSale;
    private List<StockProducto> stocks;
    private StockProducto producto;
    private String accion;
    private boolean estado;
    private Access access;
    private List<Users> users;
    private Users user;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date fecha = new Date();
    private String fecAct = sdf.format(fecha);

    public void doGenerateReport() {
        try {
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
            fecha = sdfr.parse(sdfr.format(fecha));
            Map<String, Object> parametro = new HashMap<String, Object>();
            parametro.put("fec", fecha);

//            String url = "D:/backup/NetBeansProjects/PharmaSoft/src/com/hrevfdz/report/ventas.jrxml";
//            String path = new File("src/com/hrevfdz/report/ventas.jrxml").getCanonicalPath();
            String path = "";
            String path1 = "C:/PharmaSoft-deployer/report/ventas.jrxml";
            String path2 = "/home/theo/Documentos/PharmaSoft-deployer/report/ventas2.jrxml";

            File folder1 = new File(path1);
            File folder2 = new File(path2);

            if (!folder1.exists()) {
                if (!folder2.exists()) {
                    JOptionPane.showMessageDialog(null, "La ruta y el archivo no existen", "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    path = path2;
                }
            } else {
                path = path1;
            }

            JasperReport jr = JasperCompileManager.compileReport(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (ParseException | SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindAll() {
        dao = new SaleDAO();

        try {
            final String query = "SELECT s FROM Sale s ORDER BY s.fecha DESC";
            sales = dao.findByQuery(query);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadData(DefaultTableModel dtm, JTable tblSales) throws ParseException {
        dtm = (DefaultTableModel) tblSales.getModel();

        for (Sale s : this.getSales()) {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            Object[] row = new Object[8];
            row[0] = s.getCodSale().toString();
            row[1] = s.getCodStock();
            row[2] = sdf.format(s.getFecha());
            sdf = new SimpleDateFormat("hh:mm:ss");
            row[3] = sdf.format(s.getHora());
            row[4] = String.valueOf(s.getCantidad());
            row[5] = String.valueOf(FramesUtil.Redondear(s.getPrecio()));
            row[6] = String.valueOf(FramesUtil.Redondear(s.getSubtotal()));
            row[7] = (s.getUserId() != null) ? s.getUserId() : "";
            dtm.addRow(row);
        }

        tblSales.setModel(dtm);
    }

    public void doFindStockByCod(int cod) {
        IPharmacy<StockProducto> daoS = new StockProductoDAO();

        try {
            List<StockProducto> lista = daoS
                    .findByQuery(QueriesUtil.STOCK_X_COD + cod);
            if (lista.size() == 1) {
                lista.forEach((sp) -> {
                    producto = sp;
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindByFecha() {
        SaleDAO daos = new SaleDAO();

        try {
            if (fecha != null) {
                sales.clear();
                sales = daos.findByDate(fecha);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public double doGetTotal(Date f) {
        IPharmacy daos = new SaleDAO();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");

        String query = "SELECT SUM(s.subtotal) FROM Sale s WHERE s.fecha = '";

        double total = 0;

        try {
//            query += (fecha != null) ? sdf4.format(fecha) : sdf4.format(f);
            query += sdf4.format(f);
            query += "'";
            total = daos.findBy(query) != null ? (double) daos.findBy(query) : 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
        return total;
    }

    public void calcSubtotal() {
        double c = sale.getCantidad();
        double p = producto.getMonto();
        sale.setSubtotal(p * c);
    }

    public void doFindAllStock() {
        IPharmacy<StockProducto> daoS = new StockProductoDAO();

        try {
            stocks = daoS.findAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doCreate() {
        StockProductoDAO daoSt = new StockProductoDAO();
        boolean result = false;
        boolean resultST = false;

        try {
            sale.setPrecio(producto.getMonto());
            sdf = new SimpleDateFormat("HH:mm:ss");
            Date fec = new Date();
            sale.setHora(sdf.parse(sdf.format(fec)));

            sale.setCodStock(producto);

            List<StockProducto> sps = daoSt.findByQuery(QueriesUtil.STOCK_X_COD + producto.getCodStock());
            StockProducto tempSt = new StockProducto();

            if (sps.size() == 1) {
                for (StockProducto sp : sps) {
                    tempSt = sp;
                }

                if (tempSt.getCantidad() >= sale.getCantidad()) {
                    result = dao.Create(sale);

                    if (result) {
                        producto.setCantidad(tempSt.getCantidad() - sale.getCantidad());
                        producto.setState(true);
                        resultST = daoSt.Update(producto);
                    }

                    if (result && resultST) {
                        sales.add(sales.size(), sale);
                        doFindAll();
                        JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, MessagesUtil.SAVE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No cuenta con stock para realizar esta venta", "Stock insuficiante", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doUpdate(Sale s) {
        dao = new SaleDAO();
        StockProductoDAO daoSt = new StockProductoDAO();
        boolean result = false;
        boolean resultST = false;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date fec = new Date();
            sale.setHora(sdf.parse(sdf.format(fec)));

            sale.setCodStock(producto);

            List<StockProducto> sps = daoSt.findByQuery(QueriesUtil.STOCK_X_COD + producto.getCodStock());
            List<Sale> ses = dao.findByQuery(QueriesUtil.SALE_X_COD + sale.getCodSale());
            StockProducto tempSt = new StockProducto();
            Sale tempVenta = new Sale();

            if (sps.size() == 1) {
                for (StockProducto sp : sps) {
                    tempSt = sp;
                }

                for (Sale se : ses) {
                    tempVenta = se;
                }

                if (tempSt.getCantidad() >= sale.getCantidad()) {
                    result = dao.Update(sale);
                    int venta = 0;
                    if (tempVenta.getCantidad() > sale.getCantidad()) {
                        venta = tempVenta.getCantidad() - sale.getCantidad();
                        producto.setCantidad(producto.getCantidad() + venta);
                    } else {
                        venta = sale.getCantidad() - tempVenta.getCantidad();
                        producto.setCantidad(producto.getCantidad() - venta);
                    }

                    producto.setState(true);
                    resultST = daoSt.Update(producto);

                    if (result && resultST) {
                        sales.clear();
                        doFindAll();
                        sale = new Sale();
                        JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_SUCCESS, MessagesUtil.SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, MessagesUtil.UPDATE_FAIL, MessagesUtil.FAIL_TITLE, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No cuenta con stock para realizar esta venta", "Stock insuficiante", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doGetUserActive() {
        IPharmacy<Access> daoa = new AccessDAO();

        try {
            final String query = "SELECT a FROM Access a WHERE a.id = (SELECT MAX(t.id) FROM Access t)";
            access = daoa.findBy(query);
            this.sale.setUserId(access.getUserId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindByUser(String name) {
        SaleDAO daou = new SaleDAO();

        try {
            sales = daou.findByUser(name);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doFindByNameProd(String name) {
        SaleDAO daou = new SaleDAO();

        try {
            sales = daou.findByNameProd(name);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getAllUsers() {
        IPharmacy<Users> daou = new UsersDAO();

        try {
            String query = "SELECT u FROM Users u";
            users = daou.findByQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshSales(JTable tblSale, DefaultTableModel modelSale) {
        FramesUtil.limpiarTabla(tblSale, (DefaultTableModel) tblSale.getModel());
        try {
            loadData(modelSale, tblSale);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void doDelete(Sale s) {
        dao = new SaleDAO();
        StockProductoDAO daoSt = new StockProductoDAO();

        producto = s.getCodStock();

        boolean result = false;
        boolean resultST = false;

        try {
//            StockProducto sp = daoSt.findBy(QueriesUtil.STOCK_X_COD + producto.getCodStock());
            StockProducto sp = daoSt.findBy(QueriesUtil.STOCK_X_COD + producto.getCodStock());
            producto.setCantidad(producto.getCantidad() + sale.getCantidad());

            producto.setState(true);
            resultST = daoSt.Update(producto);

            result = dao.Delete(s);

            if (result && resultST) {
                sales.clear();
                doFindAll();
                sale = new Sale();
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
        sale = new Sale();
        doFindAllStock();
        doGetUserActive();
        estado = false;
//        try {
//            sale.setFecha(sdf.parse(fecAct));
        sale.setFecha(new Date());
//        } catch (ParseException ex) {
//            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void doUpgrade(Sale s) {
        accion = AccionUtil.UPDATE;
        sale = s;
        doFindAllStock();
        tempSale = sale;
        doFindStockByCod(s.getCodStock().getCodStock());
        doGetUserActive();
        estado = true;
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(sale);
                break;
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

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
