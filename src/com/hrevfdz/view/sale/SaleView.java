package com.hrevfdz.view.sale;

import com.hrevfdz.controller.SaleController;
import com.hrevfdz.model.Sale;
import com.hrevfdz.model.StockProducto;
import com.hrevfdz.model.Users;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.ActionNamesUtil;
import com.hrevfdz.util.FramesUtil;
import com.hrevfdz.util.MessagesUtil;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SaleView extends javax.swing.JInternalFrame {

    private JDesktopPane container;

    private SimpleDateFormat sdf;
    private Date fec;

    private DefaultTableModel dtm;
    private JLabel lblMontoAct;
    private JButton btnSale;

    private final SaleController sc;

    public SaleView(JDesktopPane container, JLabel lblMontoAct, JButton btnSale) {
        initComponents();

        this.container = container;
        this.lblMontoAct = lblMontoAct;
        this.btnSale = btnSale;

        try {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            fec = sdf.parse(sdf.format(new Date()));
            dcFecha.setDate(fec);
        } catch (ParseException ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }

        sc = new SaleController();

//        ResourceBundle.getBundle("com.hrevfdz.util.ActionNames", Locale.ENGLISH).getString("SEARCH_ALL");
        btnRefreshSales.setToolTipText(ActionNamesUtil.SEARCH_ALL);
        btnReport.setToolTipText(ActionNamesUtil.PRINT);
        btnAdd.setToolTipText(ActionNamesUtil.ADD);
        btnUpdate.setToolTipText(ActionNamesUtil.UPDATE);
        btnDelete.setToolTipText(ActionNamesUtil.DELETE);

        sc.doFindAll();
        sc.getAllUsers();
        loadUsers();

        try {
            sc.loadData(dtm, tblSales);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtNomProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbUser = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnReport = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefreshSales = new javax.swing.JButton();
        btnSearchDate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();

        setBackground(new java.awt.Color(5, 67, 98));
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

        jPanel3.setBackground(new java.awt.Color(5, 67, 98));

        jPanel1.setBackground(new java.awt.Color(5, 67, 98));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha");

        dcFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        dcFecha.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Prod.");

        txtNomProd.setBackground(new java.awt.Color(255, 255, 255));
        txtNomProd.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txtNomProd.setForeground(new java.awt.Color(0, 0, 0));
        txtNomProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        txtNomProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomProdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProdKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");

        cbUser.setBackground(new java.awt.Color(255, 255, 255));
        cbUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cbUser.setForeground(new java.awt.Color(0, 0, 0));
        cbUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        cbUser.setOpaque(false);
        cbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUserActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(5, 67, 98));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 0));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnReport.setBackground(new java.awt.Color(5, 67, 98));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/report/icons8-Print-34.png"))); // NOI18N
        btnReport.setBorder(null);
        btnReport.setContentAreaFilled(false);
        btnReport.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/report/icons8-Print-28.png"))); // NOI18N
        btnReport.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/report/icons8-Print-40.png"))); // NOI18N
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(5, 67, 98));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-34.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-28.png"))); // NOI18N
        btnAdd.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-40.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(5, 67, 98));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/update/icons8-Edit Property-34.png"))); // NOI18N
        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setEnabled(false);
        btnUpdate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/update/icons8-Edit Property-28.png"))); // NOI18N
        btnUpdate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/update/icons8-Edit Property-40.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(5, 67, 98));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/delete/icons8-Trash Can-34.png"))); // NOI18N
        btnDelete.setBorder(null);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setEnabled(false);
        btnDelete.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/delete/icons8-Trash Can-28.png"))); // NOI18N
        btnDelete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/delete/icons8-Trash Can-40.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefreshSales.setBackground(new java.awt.Color(5, 67, 98));
        btnRefreshSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-34.png"))); // NOI18N
        btnRefreshSales.setBorder(null);
        btnRefreshSales.setContentAreaFilled(false);
        btnRefreshSales.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-28.png"))); // NOI18N
        btnRefreshSales.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-40.png"))); // NOI18N
        btnRefreshSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnRefreshSales, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRefreshSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnSearchDate.setBackground(new java.awt.Color(5, 67, 98));
        btnSearchDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/search/icons8-Search-24.png"))); // NOI18N
        btnSearchDate.setBorderPainted(false);
        btnSearchDate.setContentAreaFilled(false);
        btnSearchDate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/search/icons8-Search-20.png"))); // NOI18N
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(btnSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(5, 67, 98));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        tblSales.setBackground(new java.awt.Color(255, 255, 255));
        tblSales.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblSales.setForeground(new java.awt.Color(0, 0, 0));
        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Fecha", "Hora", "Cantidad", "Precio Unit.", "Subtotal", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSales.setGridColor(new java.awt.Color(255, 255, 255));
        tblSales.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblSales.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSales);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        sc.doNew();
        try {
            openEditSale(AccionUtil.NUEVA);
            FramesUtil.enablerActionButtons(btnUpdate, btnDelete, false);
        } catch (ParseException ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalesMouseClicked
        try {
            getSaleRow(sc);
            FramesUtil.enablerActionButtons(btnUpdate, btnDelete, true);
//            openEditSale(AccionUtil.UPDATE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblSalesMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (tblSales.isRowSelected(tblSales.getSelectedRow())) {
                sc.doUpgrade(sc.getSale());
                openEditSale(AccionUtil.UPDATE);
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE, JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (tblSales.isRowSelected(tblSales.getSelectedRow())) {
                getSaleRow(this.sc);
                if (JOptionPane.showConfirmDialog(null, "Esta seguro que de eliminar el producto: " + sc.getSale().getCodStock().getNombre().toUpperCase(),
                        MessagesUtil.COMFIRM_DELETE_TITLE, JOptionPane.YES_NO_OPTION) == 0) {
                    this.sc.doDelete(sc.getSale());
                    sc.doFindAll();
                    this.sc.refreshSales(tblSales, dtm);
                    this.lblMontoAct.setText("S/. " + sc.doGetMontoActualCaja(new Date()));
                }
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        btnSale.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDateActionPerformed
        sc.setFecha(dcFecha.getDate());
        sc.doFindByFecha();
        FramesUtil.limpiarTabla(tblSales, (DefaultTableModel) tblSales.getModel());
        sc.refreshSales(tblSales, dtm);
    }//GEN-LAST:event_btnSearchDateActionPerformed

    private void btnRefreshSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSalesActionPerformed
        sc.doFindAll();
        FramesUtil.limpiarTabla(tblSales, (DefaultTableModel) tblSales.getModel());
        sc.refreshSales(tblSales, dtm);
    }//GEN-LAST:event_btnRefreshSalesActionPerformed

    private void cbUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUserActionPerformed
        if (!cbUser.getSelectedItem().toString().equals("Seleccione")) {
            sc.doFindByUser(cbUser.getSelectedItem().toString());
            FramesUtil.limpiarTabla(tblSales, (DefaultTableModel) tblSales.getModel());
            sc.refreshSales(tblSales, dtm);
        }
    }//GEN-LAST:event_cbUserActionPerformed

    private void txtNomProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyReleased
        sc.doFindByNameProd(txtNomProd.getText());
        FramesUtil.limpiarTabla(tblSales, (DefaultTableModel) tblSales.getModel());
        sc.refreshSales(tblSales, dtm);
    }//GEN-LAST:event_txtNomProdKeyReleased

    private void txtNomProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtNomProdKeyTyped

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        
    }//GEN-LAST:event_btnReportActionPerformed

    private void loadUsers() {
        cbUser.addItem("Seleccione");
        sc.getUsers().forEach((u) -> {
            cbUser.addItem(u.getUsername());
        });
    }

    private void openEditSale(String title) throws ParseException {
        CUSaleView cUSaleView = new CUSaleView(sc, tblSales, dtm, lblMontoAct, container, this);
        cUSaleView.setTitle(title + cUSaleView.getTitle());
        cUSaleView.setClosable(true);
        cUSaleView.txtCantidad.requestFocus();
        cUSaleView.dcFecha.setDate(new Date());
        container.add(cUSaleView);
        FramesUtil.setPosition(this.container, cUSaleView);
        this.lblMontoAct.setText("S/. " + sc.doGetMontoActualCaja(new Date()));
        cUSaleView.show();
        this.setVisible(false);
        if (title.equals(AccionUtil.UPDATE)) {
            cUSaleView.txtCodigo.setEnabled(false);
            cUSaleView.setClosable(true);
            cUSaleView.txtCodigo.setText(sc.getSale().getCodSale().toString());
            cUSaleView.dcFecha.setDate(sc.getSale().getFecha());
            cUSaleView.txtProducto.setText(sc.getSale().getCodStock().getNombre());
            cUSaleView.txtCantidad.setText(String.valueOf(sc.getSale().getCantidad()));
            cUSaleView.txtPrecio.setText(String.valueOf(sc.getSale().getPrecio()));
            cUSaleView.txtSubtotal.setText(String.valueOf(sc.getSale().getSubtotal()));
        }
    }

    private void getSaleRow(SaleController sc) throws ParseException {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        sc.setSale(new Sale());
        sc.getSale().setCodSale(Integer.parseInt(tblSales.getValueAt(tblSales.getSelectedRow(), 0).toString()));
        sc.getSale().setCodStock((StockProducto) tblSales.getValueAt(tblSales.getSelectedRow(), 1));
        Date temp = sdf.parse(tblSales.getValueAt(tblSales.getSelectedRow(), 2).toString());
        sc.getSale().setFecha(sdf.parse(sdf.format(temp)));
        sdf = new SimpleDateFormat("HH:mm:ss");
        temp = sdf.parse(tblSales.getValueAt(tblSales.getSelectedRow(), 3).toString());
        sc.getSale().setHora(sdf.parse(sdf.format(temp)));
        sc.getSale().setCantidad(Integer.parseInt(tblSales.getValueAt(tblSales.getSelectedRow(), 4).toString()));
        try {
            String num = tblSales.getValueAt(tblSales.getSelectedRow(), 5).toString();
            sc.getSale().setPrecio(Double.parseDouble(num));
            sc.getSale().setSubtotal(Double.parseDouble(tblSales.getValueAt(tblSales.getSelectedRow(), 6).toString()));
            sc.getSale().setUserId((Users) tblSales.getValueAt(tblSales.getSelectedRow(), 7));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefreshSales;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSearchDate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbUser;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtNomProd;
    // End of variables declaration//GEN-END:variables
}
