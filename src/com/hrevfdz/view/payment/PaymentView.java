package com.hrevfdz.view.payment;

import com.hrevfdz.controller.PaymentsController;
import com.hrevfdz.model.Payments;
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
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class PaymentView extends javax.swing.JInternalFrame {
    
    JDesktopPane container;
    JButton btnPay;
    
    DefaultTableModel dtm;
    
    private final PaymentsController pc;
    private JLabel lblMontoAct;
    
    private SimpleDateFormat sdf;
    
    public PaymentView(JDesktopPane container, JButton btnPay, JLabel lblMontoAct) {
        initComponents();
        
        this.container = container;
        this.btnPay = btnPay;
        this.lblMontoAct = lblMontoAct;
        
        pc = new PaymentsController();
        
        btnRefresh.setToolTipText(ActionNamesUtil.SEARCH_ALL);
        btnAddPay.setToolTipText(ActionNamesUtil.ADD);
        btnUpdate.setToolTipText(ActionNamesUtil.UPDATE);
        btnDelete.setToolTipText(ActionNamesUtil.DELETE);
        
        dcFechaPay.setDate(new Date());
        
        pc.doFindAll();
        pc.doGetUserActive();
        pc.doGetAllUsers();
        loadUsers();
        
        try {
            FramesUtil.limpiarTabla(tblPayments, (DefaultTableModel) tblPayments.getModel());
            pc.loadData(dtm, tblPayments);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dcFechaPay = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbUserPay = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        btnAddPay = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnSearchDate = new javax.swing.JButton();
        txtNomProd = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayments = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
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

        jPanel7.setBackground(new java.awt.Color(5, 67, 98));

        jPanel8.setBackground(new java.awt.Color(5, 67, 98));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha");

        dcFechaPay.setBackground(new java.awt.Color(255, 255, 255));
        dcFechaPay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        dcFechaPay.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre Prod.");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario");

        cbUserPay.setBackground(new java.awt.Color(255, 255, 255));
        cbUserPay.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        cbUserPay.setForeground(new java.awt.Color(0, 0, 0));
        cbUserPay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        cbUserPay.setOpaque(false);
        cbUserPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUserPayActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(5, 67, 98));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(5, 0));

        btnAddPay.setBackground(new java.awt.Color(5, 67, 98));
        btnAddPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-34.png"))); // NOI18N
        btnAddPay.setBorder(null);
        btnAddPay.setContentAreaFilled(false);
        btnAddPay.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-28.png"))); // NOI18N
        btnAddPay.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/add/icons8-Add List-40.png"))); // NOI18N
        btnAddPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPayActionPerformed(evt);
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

        btnRefresh.setBackground(new java.awt.Color(5, 67, 98));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-34.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-28.png"))); // NOI18N
        btnRefresh.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/action/refresh/icons8-Available Updates-40.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddPay, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAddPay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFechaPay, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbUserPay, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dcFechaPay, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(btnSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUserPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(5, 67, 98));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        tblPayments.setBackground(new java.awt.Color(255, 255, 255));
        tblPayments.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblPayments.setForeground(new java.awt.Color(0, 0, 0));
        tblPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fecha", "Monto", "Descripción", "Usuario", "Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPayments.setGridColor(new java.awt.Color(255, 255, 255));
        tblPayments.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblPayments.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblPayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaymentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPayments);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPayActionPerformed
        pc.doNew();
        JInternalFrame cu = openCUPayment();
        cu.setTitle(AccionUtil.CREATE + cu.getTitle());
        FramesUtil.setPosition(container, cu);
        FramesUtil.enablerActionButtons(btnUpdate, btnDelete, false);
        cu.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnAddPayActionPerformed
    
    private JInternalFrame openCUPayment() {
        CUPaymentView cUPaymentView = new CUPaymentView(pc, this, container, tblPayments, dtm, this.lblMontoAct);
        cUPaymentView.setClosable(true);
        cUPaymentView.txtUser.setText(pc.getPayments().getUserId().getUsername().toUpperCase());
        container.add(cUPaymentView);
        return cUPaymentView;
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//        try {
        if (tblPayments.isRowSelected(tblPayments.getSelectedRow())) {
            pc.doUpgrade(pc.getPayments());
            CUPaymentView cu = new CUPaymentView(pc, this, container, tblPayments, dtm, this.lblMontoAct);
            cu.setClosable(true);
            cu.setTitle(AccionUtil.UPDATE + cu.getTitle());
            cu.txtCodigo.setText(pc.getPayments().getCodigo().toString());
            cu.txtUser.setText(pc.getPayments().getUserId().getUsername().toUpperCase());
            cu.dcFecha.setDate(pc.getPayments().getFecha());
            String temp1 = "";
            String temp2 = "";
            if (pc.getPayments().getCodStock() != null) {
                temp1 = pc.getPayments().getCodStock().getCodLab().getNomLab();
                temp2 = pc.getPayments().getCodStock().getNombre();
            }
            cu.txtLaboratory.setText(temp1);
            cu.txtProducto.setText(temp2);
            cu.txtMonto.setText(String.valueOf(pc.getPayments().getMonto()));
            cu.txtDescripcion.setText((pc.getPayments().getDescripcion()));
            container.add(cu);
            FramesUtil.setPosition(container, cu);
            cu.show();
        } else {
            JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE, JOptionPane.ERROR_MESSAGE);
        }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.SELECTED_ROW_TITLE, JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (tblPayments.isRowSelected(tblPayments.getSelectedRow())) {
                this.getPayRow();
                if (JOptionPane.showConfirmDialog(null, "Esta seguro que de eliminar el pago  con Id: " + pc.getPayments().getCodigo(),
                        MessagesUtil.COMFIRM_DELETE_TITLE, JOptionPane.YES_NO_OPTION) == 0) {
                    this.pc.doDelete(pc.getPayments());
                    this.pc.doFindAll();
                    this.pc.refreshPayments(dtm, tblPayments);
                    this.lblMontoAct.setText("S/. " + pc.doGetMontoActualCaja(new Date()));
                }
            } else {
                JOptionPane.showMessageDialog(null, MessagesUtil.SELECTED_ROW_MSG, MessagesUtil.SELECTED_ROW_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblPaymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaymentsMouseClicked
        try {
            getPayRow();
            FramesUtil.enablerActionButtons(btnUpdate, btnDelete, true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), MessagesUtil.ERROR_SERVER_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblPaymentsMouseClicked
    
    private void getPayRow() throws ParseException {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        pc.setPayments(new Payments());
        pc.getPayments().setCodigo(Integer.parseInt(tblPayments.getValueAt(tblPayments.getSelectedRow(), 0).toString()));
        pc.getPayments().setFecha(sdf.parse(tblPayments.getValueAt(tblPayments.getSelectedRow(), 1).toString()));
        pc.getPayments().setMonto(Double.parseDouble(tblPayments.getValueAt(tblPayments.getSelectedRow(), 2).toString()));
        pc.getPayments().setDescripcion(tblPayments.getValueAt(tblPayments.getSelectedRow(), 3).toString());
        pc.getPayments().setUserId((Users) tblPayments.getValueAt(tblPayments.getSelectedRow(), 4));
        pc.getPayments().setCodStock((StockProducto) tblPayments.getValueAt(tblPayments.getSelectedRow(), 5));
    }

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        btnPay.setEnabled(true);
    }//GEN-LAST:event_formInternalFrameClosing
    
    public void loadUsers() {
        cbUserPay.addItem("Seleccione");
        pc.getUserses().forEach((u) -> {
            cbUserPay.addItem(u.getUsername());
        });
    }

    private void btnSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDateActionPerformed
        pc.setFecha(dcFechaPay.getDate());
        pc.doFindByFecha();
        FramesUtil.limpiarTabla(tblPayments, (DefaultTableModel) tblPayments.getModel());
        pc.refreshPayments(dtm, tblPayments);
    }//GEN-LAST:event_btnSearchDateActionPerformed

    private void cbUserPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUserPayActionPerformed
        if (!cbUserPay.getSelectedItem().toString().equals("Seleccione")) {
            pc.doFindByUser(cbUserPay.getSelectedItem().toString());
            FramesUtil.limpiarTabla(tblPayments, (DefaultTableModel) tblPayments.getModel());
            pc.refreshPayments(dtm, tblPayments);
        }
    }//GEN-LAST:event_cbUserPayActionPerformed

    private void txtNomProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyReleased
        pc.doFindByNameProd(txtNomProd.getText());
        FramesUtil.limpiarTabla(tblPayments, (DefaultTableModel) tblPayments.getModel());
        pc.refreshPayments(dtm, tblPayments);
    }//GEN-LAST:event_txtNomProdKeyReleased

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        FramesUtil.limpiarTabla(tblPayments, (DefaultTableModel) tblPayments.getModel());
        pc.doFindAll();
        pc.refreshPayments(dtm, tblPayments);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtNomProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyTyped
        FramesUtil.convertToMayucula(evt);
    }//GEN-LAST:event_txtNomProdKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPay;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchDate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbUserPay;
    private com.toedter.calendar.JDateChooser dcFechaPay;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tblPayments;
    private javax.swing.JTextField txtNomProd;
    // End of variables declaration//GEN-END:variables
}
