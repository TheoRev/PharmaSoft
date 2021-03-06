package com.hrevfdz.view.stock;

import com.hrevfdz.controller.SaleController;
import com.hrevfdz.controller.StockController;
import com.hrevfdz.model.Laboratory;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.util.MessagesUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StockSelectorView extends javax.swing.JInternalFrame {

    private StockController stc = null;
    private SaleController sc = null;
    private JInternalFrame iframe = null;
    private JDesktopPane container = null;
    JTextField txtProducto;
    JTextField txtPrecio;
    JTextField txtCantidad;

    private DefaultTableModel dtm;
    private SimpleDateFormat sdf;

    JTable tblSale;
    DefaultTableModel modelSale;

    public StockSelectorView(SaleController sc, JInternalFrame iframe, JDesktopPane container, JTable tblSale,
            DefaultTableModel modelSale, JLabel lblMontoAct, JTextField txtProducto, JTextField txtPrecio, JTextField txtCantidad) {
        initComponents();
        this.sc = sc;
        this.iframe = iframe;
        this.container = container;
        this.tblSale = tblSale;
        this.modelSale = modelSale;
        this.txtProducto = txtProducto;
        this.txtPrecio = txtPrecio;
        this.txtCantidad = txtCantidad;

        stc = new StockController();
        stc.doFindAll();
        doFindAll();
    }

    private void doFindAll() {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        dtm = (DefaultTableModel) tblProductos.getModel();

        stc.getStockProductos().stream().map((p) -> {
            Object[] row = new Object[8];
            row[0] = p.getCodStock();
            row[1] = p.getNombre();
            row[2] = p.getPresentacion();
            row[3] = p.getCodLab();
            row[4] = p.getLote();
            row[5] = p.getMonto();
            row[6] = p.getCantidad();
            row[7] = (p.getFecVen() != null) ? sdf.format(p.getFecVen()) : "";
            return row;
        }).forEachOrdered((row) -> {
            dtm.addRow(row);
        });

        tblProductos.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomProd = new javax.swing.JTextField();
        txtLaboratorio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setClosable(true);
        setTitle("SELECCIONE UN PRODUCTO");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(5, 67, 98));

        jPanel2.setBackground(new java.awt.Color(5, 67, 98));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Prod.");

        txtNomProd.setBackground(new java.awt.Color(255, 255, 255));
        txtNomProd.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNomProd.setForeground(new java.awt.Color(0, 0, 0));
        txtNomProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNomProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomProdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProdKeyTyped(evt);
            }
        });

        txtLaboratorio.setBackground(new java.awt.Color(255, 255, 255));
        txtLaboratorio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        txtLaboratorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLaboratorioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLaboratorioKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Laboratorio");

        btnAceptar.setBackground(new java.awt.Color(255, 255, 102));
        btnAceptar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(52, 152, 219));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/comfirm/icons8-Ok-24.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(52, 152, 219), 2, true));
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomProd, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(5, 67, 98));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        tblProductos.setBackground(new java.awt.Color(255, 255, 255));
        tblProductos.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblProductos.setForeground(new java.awt.Color(0, 0, 0));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Presentación", "Laboratorio", "Lote", "Precio.", "Cantidad", "Fec. Venc."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tblProductos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblProductos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        iframe.setVisible(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        try {
            btnAceptar.setEnabled(true);
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            sc.setProducto(new StockProducto());
            sc.getProducto().setCodStock(Integer.parseInt(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString()));
            sc.getProducto().setNombre(tblProductos.getValueAt(tblProductos.getSelectedRow(), 1).toString());
            sc.getProducto().setPresentacion(tblProductos.getValueAt(tblProductos.getSelectedRow(), 2).toString());
            sc.getProducto().setCodLab((Laboratory) tblProductos.getValueAt(tblProductos.getSelectedRow(), 3));
            sc.getProducto().setLote(tblProductos.getValueAt(tblProductos.getSelectedRow(), 4).toString());
            sc.getProducto().setMonto((double) tblProductos.getValueAt(tblProductos.getSelectedRow(), 5));
            sc.getProducto().setCantidad((Integer) tblProductos.getValueAt(tblProductos.getSelectedRow(), 6));
            Date fecv = sdf.parse(tblProductos.getValueAt(tblProductos.getSelectedRow(), 7).toString());
            sc.getProducto().setFecVen(sdf.parse(sdf.format(fecv)));
        } catch (ParseException ex) {
            Logger.getLogger(StockSelectorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblProductos.isRowSelected(tblProductos.getSelectedRow())) {
            txtProducto.setText(sc.getProducto().getNombre());
            this.txtPrecio.setText(String.valueOf(sc.getProducto().getMonto()));
            this.txtCantidad.setEnabled(true);
            this.txtCantidad.setText("");
            this.txtCantidad.requestFocus(true);
            this.dispose();
            iframe.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNomProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyReleased
        stc.setStockProductos(stc.doFindStockByName(txtNomProd.getText()));
        FramesUtil.limpiarTabla(tblProductos, (DefaultTableModel) tblProductos.getModel());
        doFindAll();
    }//GEN-LAST:event_txtNomProdKeyReleased

    private void txtLaboratorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLaboratorioKeyReleased
        stc.setStockProductos(stc.doFindStockByNameLab(txtLaboratorio.getText()));
        FramesUtil.limpiarTabla(tblProductos, (DefaultTableModel) tblProductos.getModel());
        doFindAll();
    }//GEN-LAST:event_txtLaboratorioKeyReleased

    private void txtNomProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtNomProdKeyTyped

    private void txtLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLaboratorioKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtLaboratorioKeyTyped

//    private void openNewSale(String title, StockProducto sp) throws ParseException {
//        sdf = new SimpleDateFormat("dd/MM/yyyy");
////        DecimalFormat df = new DecimalFormat("00.00");
//        Date fecact = new Date();
//        fecact = sdf.parse(sdf.format(fecact));
//        CUSaleView cUSaleView = new CUSaleView(sc, tblSale, modelSale, lblMontoAct, container);
//        cUSaleView.txtCodigo.setEnabled(false);
//        cUSaleView.setClosable(true);
//        cUSaleView.setTitle(title + cUSaleView.getTitle());
//        cUSaleView.getSc().setProducto(sp);
//        cUSaleView.txtProducto.setText(sp.getNombre());
//        cUSaleView.dcFecha.setDate(fecact);
//        cUSaleView.txtCantidad.requestFocus();
//        cUSaleView.txtPrecio.setText((sp.getMonto()).toString());
//        cUSaleView.txtCantidad.requestFocus();
//        cUSaleView.getSc().doNew();
//        container.add(cUSaleView);
//        FramesUtil.setPosition(this.container, cUSaleView);
//        cUSaleView.show();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtLaboratorio;
    private javax.swing.JTextField txtNomProd;
    // End of variables declaration//GEN-END:variables
}
